package com.mum.batchprocess.controller;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

   @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/")
    public String toUpDate(){
       return "redirect:/upload/";
    }

}
