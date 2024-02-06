package com.zergatstage.gbsprings03.repository;

import com.zergatstage.gbsprings03.model.User;
import com.zergatstage.gbsprings03.services.SQLTemplates;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    private final SQLTemplates sqlTemplates;
    public UserRepository(JdbcTemplate jdbc, SQLTemplates templates) {
        this.jdbc = jdbc;
        this.sqlTemplates = templates;
    }

    public List<User> findAll(){
        //String sql = "SELECT * FROM users";
        return jdbc.query(sqlTemplates.getFindAllUsers(), new UserRowMapper());
    }
    public User findById(int id){
        //String sql = "SELECT * FROM users where id=?";
        return jdbc.queryForObject(sqlTemplates.getFindUserById(), new BeanPropertyRowMapper<>(User.class),id);
    }


    public User save(User user){
        //String sql = "INSERT INTO users (userAge, userName, email) VALUES (?,?,?)";
        jdbc.update(sqlTemplates.getInsertUser(),user.getAge(), user.getName(),user.getEmail());
        return user;
    }

    public User update(User user){
        //String sql = "UPDATE users SET userAge=?, userName=?, email=? WHERE id=?";
        jdbc.update(sqlTemplates.getUpdateUser(),user.getAge(), user.getName(), user.getEmail(), user.getId());
        return user;
    }

    public void deleteById(int id){
        //String sql = "DELETE FROM users WHERE id=?";
        jdbc.update(sqlTemplates.getDeleteUser(),id);
    }


    static class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User rowObject = new User();
            rowObject.setId((rs.getInt("id")));
            rowObject.setName(rs.getString("userName"));
            rowObject.setEmail(rs.getString("email"));
            rowObject.setAge(rs.getInt("userAge"));
            return rowObject;
        }
    }


}
