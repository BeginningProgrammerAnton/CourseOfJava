package com.my_company.comp.models.controllers;

import com.my_company.comp.models.Find;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FindController {

    @GetMapping("/find")
    public String findForm(Model model) {
        model.addAttribute("find",new Find());
        return "find";
    }

    @PostMapping("/find")
    public String findSubmit(@ModelAttribute Find find, HttpServletRequest request) {
        if (find.checkInto(find.getFirstName(),find.getLastName())) {
            UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
            find.setBrowser(userAgent.getBrowser().getName() + " " + userAgent.getBrowserVersion());
            return "found";
        } else {

            return "notFound";
        }
    }
}
