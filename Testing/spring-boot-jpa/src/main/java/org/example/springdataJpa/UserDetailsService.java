package org.example.springdataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    public UserDetails saveUserDetails(UserDetails userDetails){
        return userDetailsRepository.save(userDetails);
    }

    public UserDetails getUserDetails(Long id){
        return userDetailsRepository.findById(id).get();
    }

    public void deleteUserDetails(Long id){
        userDetailsRepository.deleteById(id);
    }
}
