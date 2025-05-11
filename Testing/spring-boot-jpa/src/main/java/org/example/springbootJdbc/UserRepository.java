package org.example.springbootJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUserTable() {
        jdbcTemplate.execute("CREATE TABLE users (id SERIAL, name VARCHAR(255))");
    }

    public void insertUser(int id, String name) {
        jdbcTemplate.execute("INSERT INTO users VALUES (" + id + ",'" + name + "')");
    }

    public void selectUser(int id) {
        jdbcTemplate.query("SELECT * FROM users WHERE id = " + id, (rs, rowNum) -> rs.getString("name"))
                .forEach(name -> System.out.println("Name: " + name));
    }

    public void updateUser(int id, String name) {
        jdbcTemplate.update("UPDATE users SET name =?1 WHERE id =?2",(ps)->{
            ps.setInt(2, id);
            ps.setString(1, name);
        });
    }
}
