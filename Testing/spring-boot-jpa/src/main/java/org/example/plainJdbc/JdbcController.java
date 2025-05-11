package org.example.plainJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jdbc")
public class JdbcController{

    @Autowired
    UserDao userDao;

    @GetMapping("/createUserTable")
    public void createUserTable(){
        userDao.createUserTable();
        insertUser(1, "John");
        selectUser(1);
    }

    @GetMapping
    public void insertUser(int id, String name){
        userDao.insertUser(id, name);
    }

    public void selectUser(int id){
        userDao.selectUser(id);
    }
}
