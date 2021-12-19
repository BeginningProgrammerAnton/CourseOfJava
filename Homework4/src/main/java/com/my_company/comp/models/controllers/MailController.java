package com.my_company.comp.models.controllers;


import com.my_company.comp.models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {

    @Autowired
    private SendMailService service;

    @GetMapping("/mail")
    public String greetingForm(Model model) {
        model.addAttribute("mail",new Mail());
        return "mail";
    }
    @PostMapping("/mail")
    public String greetingSubmit(@ModelAttribute("mail")Mail mail) {
        service.sendSimpleEmail(mail.getEmail(),mail.getMessage());
        return "mail";
    }

}
