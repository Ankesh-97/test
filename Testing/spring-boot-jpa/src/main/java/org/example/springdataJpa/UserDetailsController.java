package org.example.springdataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/save")
    public UserDetails saveUserDetails(@RequestBody UserDetails userDetails){
         UserDetails userDetails1 = userDetailsService.saveUserDetails(userDetails);
        return userDetailsService.getUserDetails(userDetails1.id);
    }

    @GetMapping("/get/{id}")
    public UserDetails getUserDetails(@PathVariable Long id){
        return userDetailsService.getUserDetails(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserDetails(@PathVariable Long id){
        userDetailsService.deleteUserDetails(id);
    }
}
