package com.example.demo.service.impl;


import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
       return userMapper.getAll();
    }

    @Override
    public long insert(User user) {
        userMapper.insert(user);
        //该对象的自增ID
        Long id = user.getId();
        return id;
    }


    public User getOne(long id){
        return userMapper.getOne(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(long id) {
       userMapper.delete(id);
    }

}
