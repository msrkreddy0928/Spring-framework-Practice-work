package com.example.SpringSecuritydemo.Service;

import com.example.SpringSecuritydemo.Entity.Users;
import com.example.SpringSecuritydemo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Long createUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepo.save(user);
        return user.getId();
    }

    public boolean changePassword(Users appUser, String newPassword){
        appUser.setPassword(passwordEncoder.encode(newPassword));
        appUser = userRepo.save(appUser);
        return true;
    }

}
