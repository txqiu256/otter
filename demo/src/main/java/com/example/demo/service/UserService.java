package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAll();

    public long insert(User user);

    public User getOne(long id);

    public void update(User user);

    public void delete(long id);
}
