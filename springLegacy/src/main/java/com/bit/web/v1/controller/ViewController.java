package com.bit.web.v1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;


@Controller
public class ViewController {
    
    private static final Logger log = LoggerFactory.getLogger(ViewController.class);
    @GetMapping("/view")
    public String helloSpring(Locale locale, Model model) {
        log.info("Welcome home! The client locale is {}.", "hello");
        model.addAttribute("data", "hello!");
        return "hello";
    }
}
