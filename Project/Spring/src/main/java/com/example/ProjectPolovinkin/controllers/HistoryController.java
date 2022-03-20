package com.example.ProjectPolovinkin.controllers;


import com.example.ProjectPolovinkin.model.history.History;
import com.example.ProjectPolovinkin.model.UserBook;
import com.example.ProjectPolovinkin.model.repositories.HistoryRepository;
import com.example.ProjectPolovinkin.model.repositories.UserBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoryController {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    UserBookRepository userBookRepository;

    @GetMapping("/history")
    public ResponseEntity<List<History>> getAllHistory(@RequestParam(required = false) String name) {
        List<History> h = new ArrayList<>();
        historyRepository.getCredit().forEach(h::add);
        System.out.println(h);

        Calendar cal = Calendar.getInstance();
        List<UserBook> userBooks = new ArrayList<UserBook>();
        userBookRepository.findAll().forEach(userBooks::add);
        for (UserBook tmp: userBooks) {
            if (tmp.getComebackDate().before(cal.getTime())) {
                tmp.setCredit(true);
                tmp.getUser().setCountCredits(tmp.getUser().getCountCredits() + 1);
                userBookRepository.save(tmp);
            }
        }
        try {
            List<History> histories = new ArrayList<History>();
            historyRepository.findAll().forEach(histories::add);
            if (histories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(histories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
