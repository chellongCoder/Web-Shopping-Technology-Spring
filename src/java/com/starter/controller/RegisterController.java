/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author chellong
 */
@Controller
public class RegisterController {
    /**
     * @TODO:
     */
    @RequestMapping("/register.htm")
    public String register() {
        return "register";
    }

    @RequestMapping("/handleRegister.htm")
    public String handleRegister(ModelMap model, 
            RedirectAttributes ra,
            @RequestParam("name") String name, 
            @RequestParam("email") String email, 
            @RequestParam("password") String password, 
            @RequestParam("checkbox-signup") String checkbox) {
        System.out.println("============================");
        System.out.println("name " + name + "email " + email + "password " + password + "checkbox " + checkbox);
        System.out.println("============================");
        ra.addFlashAttribute("register", "success");
        return "redirect:/login.htm";
    }
}
