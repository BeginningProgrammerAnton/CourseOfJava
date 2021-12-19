package com.my_company.comp.models.controllers;


import com.my_company.comp.models.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting",new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute("greeting") @Valid Greeting greeting, BindingResult bindingResult, HttpServletResponse resp) {
        if (bindingResult.hasErrors()) {
            return "greeting";
        }
        String s = greeting.getLastName()+ " " + greeting.getFirstName()+ "," + greeting.getFatherName()+ "," + greeting.getAge()+ "," + greeting.getSalary()+ "," + greeting.getEmail()+ "," + greeting.getWorkPlace();
        greeting.write(s);
        return "result";
    }
}
