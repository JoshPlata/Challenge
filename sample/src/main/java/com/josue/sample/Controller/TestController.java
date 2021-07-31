package com.josue.sample.Controller;

import com.josue.sample.Service.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private Test test;

    @GetMapping("/test")
    public void test(){
        test.Test();
    }
}
