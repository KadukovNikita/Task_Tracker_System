package com.kadukov.spring.project.spring_project.service;

import com.kadukov.spring.project.spring_project.dao.UserDAO;
import com.kadukov.spring.project.spring_project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public User getUser(String name) {
        return userDAO.getUser(name);
    }

    @Transactional
    @Override
    public List<User> getAllUsers(String role) {
        return userDAO.getAllUsers(role);
    }

    @Transactional
    @Override
    public void changeRole(String name) {
        User user = userDAO.getUser(name);
        if(user.getRole().equals("subAdmin")){
            user.setRole("user");
            userDAO.saveUser(user);
        }
        else{
            user.setRole("subAdmin");
            userDAO.saveUser(user);
        }
    }

    @Transactional
    @Override
    public boolean valid(User user) {
        List<User> listUsers = getAllUsers("all");
        for(User curUser: listUsers){
            if(curUser.getUsername().equals(user.getUsername())){
                if(curUser.getPassword().equals(user.getPassword()) && curUser.isEnabled()){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    @Transactional
    @Override
    public void blockUser(String name) {
        User user = userDAO.getUser(name);
        user.setEnabled(!user.isEnabled());
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public User whichEmail(String email){
        for(User user: getAllUsers("all")){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}
