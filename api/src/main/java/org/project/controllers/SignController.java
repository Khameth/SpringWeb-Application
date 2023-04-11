package org.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignController {
    @GetMapping("/")
    public String sign(Model model){
        model.addAttribute("title","Sign page");
        return "sign_in/sign_in";
    }





}
