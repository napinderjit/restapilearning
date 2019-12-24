package com.learning.restapilearning.service;

import com.learning.restapilearning.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserService {

    private static List<User> users = new ArrayList<User>();
    private static Long usersCount = 103L;
    static{
        users.add(new User(101L,"Jack",new Date()));
        users.add(new User(102L,"James",new Date()));
        users.add(new User(103L,"Hanna",new Date()));
    }

    public List<User> findAll(){

        return users;
    }

    public User save(User user){
        if(user.getId()==null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findById(Long id){
        for (User user: users) {
            if(user.getId()==id)
                return user;
        }
        return null;
    }

    public User deleteById(Long id){
        for (User user: users) {
            if(user.getId()==id) {
                users.remove(user);
                return user;
            }
        }
        return null;
    }

    public User updateUser(User user){
        for (User u:users) {
            if(u.getId()==user.getId()){
                u.setName(user.getName());
                u.setBirthdate(user.getBirthdate());
                return u;
            }
        }
        return null;
    }
}