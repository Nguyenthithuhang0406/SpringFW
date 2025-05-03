package com.vti.helloworld.controller;

import com.vti.helloworld.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> test(@RequestParam(value = "x", required = false) String username, @RequestParam(value = "y") String password) {
        //day la 1 chuc nang
//        tu giao dien muon truy cap vao method nay
        // de thuc hien 1 chuc nang

        //Khi khong khai bao j them hoac la @RequestParam thi bien se duoc lay tu params
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return ResponseEntity.ok("Hello World 1");
    }

    @GetMapping("/hello")
    public String hello(User user) {
        System.out.println(user);
        //day la 1 chuc nang
        return "Hello World 2";
    }

    //value trong co the co hoac khong
    @GetMapping("/{id}")
    public String test3(@PathVariable(value = "id") int id) {
        System.out.println("id: " + id);
        //day la 1 chuc nang
        return "Hello World 3";
    }

    @GetMapping("/abc")
    public String test4(@RequestBody User user) {
        System.out.println(user);
        //day la 1 chuc nang
        return "Hello World 4";
    }
}
