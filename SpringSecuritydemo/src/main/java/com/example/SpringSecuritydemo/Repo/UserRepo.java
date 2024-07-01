package com.example.SpringSecuritydemo.Repo;

import com.example.SpringSecuritydemo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
