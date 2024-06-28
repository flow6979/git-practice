package com.example.ColorAssignment.controller;

import com.example.ColorAssignment.service.myservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class mycontroller {

    private final myservice myService;

    @Autowired
    public mycontroller(myservice MyService) {
        this.myService = MyService;
    }

    @GetMapping("/list")
    public Set<String> listSubscriptions() {
        return myService.listSubscriptions();
    }

    @PostMapping("/subscribe")
    public void subscribe(@RequestParam String name) {
        myService.subscribe(name);
    }

    @PostMapping("/notification")
    public List<String> notifySubscribers(@RequestParam String color) {
        return myService.notifySubscribers(color);
    }

}
