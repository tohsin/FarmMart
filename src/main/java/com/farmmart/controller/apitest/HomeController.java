package com.farmmart.controller.apitest;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HomeController {

    @GetMapping("hello")
    public String home(){
        return "Welcome to Farm Mart Store";
    }

    @GetMapping("index")
    public String login(){
        return "index";
    }
}

