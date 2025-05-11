package org.example.springbootJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    UserRepository userDao;

    @GetMapping("/createUserTable")
    public void createUserTable(){
        userDao.createUserTable();
        userDao.insertUser(1, "John");
        userDao.selectUser(1);
    }
}
