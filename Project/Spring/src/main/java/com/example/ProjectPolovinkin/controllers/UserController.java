package com.example.ProjectPolovinkin.controllers;

import com.example.ProjectPolovinkin.helpers.MessageResponse;
import com.example.ProjectPolovinkin.model.*;

import com.example.ProjectPolovinkin.model.history.PopularUsers;
import com.example.ProjectPolovinkin.model.history.UsersCredits;
import com.example.ProjectPolovinkin.model.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBookRepository userBookRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RoleRepository roleRepository;



    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllBooks(@RequestParam(required = false) String name) {
        try {
            List<User> users = new ArrayList<User>();
            userRepository.findAll().forEach(users::add);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        Optional<User> userData = userRepository.findById(id);
        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/users/popular")
    public ResponseEntity<List<PopularUsers>> getAllPopular(@RequestParam(required = false) String name) {
        try {
            List<Long> b = new ArrayList<Long>();
            List<Integer> c = new ArrayList<Integer>();
            historyRepository.popularUsers().forEach(b::add);
            historyRepository.popularUsersCount().forEach(c::add);
            List<User> users = new ArrayList<User>();
            List<PopularUsers> popularUsers= new ArrayList<PopularUsers>();
            for (Integer i = 0; i < b.size();++i) {
                Optional<User> userData = userRepository.findById(b.get(i));
                PopularUsers tmp = new PopularUsers(userData.get().getUsername(),userData.get().getFirstName(),userData.get().getLastName(),c.get(i),b.get(i));
                popularUsers.add(tmp);
            }
            if (popularUsers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(popularUsers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/bad")
    public ResponseEntity<List<UsersCredits>> getAllBad(@RequestParam(required = false) String name) {
        try {
            List<Long> userId = new ArrayList<>();
            historyRepository.getUsersCredit().forEach(userId::add);
            List<Integer> countCredit = new ArrayList<>();
            historyRepository.getCountUsersCredit().forEach(countCredit:: add);
            List<UsersCredits> usersCredits = new ArrayList<>();
            for (Integer i = 0; i < userId.size();++i) {
                List<Long> books= new ArrayList<>();
                historyRepository.getCreditBooksUser(userId.get(i)).forEach(books::add);

                Set<Book> bookCredit = new HashSet<>();
                for (Long cur: books) {
                    Optional<Book> b = bookRepository.findById(cur);
                    bookCredit.add(b.get());
                }
                Optional<User> userDate = userRepository.findById(userId.get(i));
                UsersCredits tmp = new UsersCredits(userId.get(i),userDate.get().getUsername(),countCredit.get(i),bookCredit);
                usersCredits.add(tmp);
            }

            if (usersCredits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(usersCredits, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> addRole(@PathVariable("id") long id, @RequestBody User user) {
        Optional<User> userDate = userRepository.findById(id);
        if (userDate.isPresent()) {
            User newUser = userDate.get();
            Set<Role> roles = newUser.getRoles();
            Role userRole = roleRepository
                    .findByName(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException("Error, Role Mod is not found"));
            roles.add(userRole);
            newUser.setRoles(roles);
            userRepository.save(newUser);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
