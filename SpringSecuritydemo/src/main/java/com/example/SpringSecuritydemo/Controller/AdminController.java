package com.example.SpringSecuritydemo.Controller;

import com.example.SpringSecuritydemo.Entity.Users;
import com.example.SpringSecuritydemo.Service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AppUserService appUserService;


    @GetMapping
    public String getHelloApp() {
        LOGGER.info("Processing hello req ");
        return "Hello App!! from Admin " + Thread.currentThread().getName();
    }

    @PostMapping("/createuser")
    public Long createUser(@RequestBody Users user) {
        Long id = appUserService.createUser(user);
        return id;
    }

    @GetMapping("/changePassword")
    public ResponseEntity<String> changePassword(@AuthenticationPrincipal Users appUser, @RequestParam String newPassword) {
        appUserService.changePassword(appUser, newPassword);
        return ResponseEntity.ok("Password changed");

    }
}
