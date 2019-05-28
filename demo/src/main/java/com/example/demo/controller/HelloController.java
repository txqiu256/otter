package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController{
    @Autowired
    private UserService userService;

    @RequestMapping(value="/getAll",method=RequestMethod.GET)
    public List<User> getAll(){

      return userService.getAll();

    }

    @RequestMapping(value="insert",method = RequestMethod.GET)
    public User insertUser(@RequestParam("name") String name,@RequestParam("gender") int gender){
        User user=new User();
        user.setName(name);
        user.setGender(gender);
        long keyId= userService.insert(user);
        user.setId(keyId);
        return user;
    }


    @RequestMapping(value="getOne",method = RequestMethod.GET)
    public User insertUser(@RequestParam("id") long id){

        return userService.getOne(id);
    }


    @RequestMapping(value="update",method = RequestMethod.POST)
    public String updateUser(@RequestBody String entity){
        Gson gson=new Gson();
        User user=gson.fromJson(entity,User.class);
        userService.update(user);
        return "success";
    }


    @RequestMapping(value="delete",method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") long id){

        userService.delete(id);
        return "success";
    }

}
