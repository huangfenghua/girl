package com.hfh.girl.service;

import com.hfh.girl.entity.Person;
import com.hfh.girl.mapper.UserDao;
import com.hfh.girl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDao userDao;

    public Person selectUser(int id) {
        return userMapper.selectUser(id);
    }

    public int InsertUser(int id,String name,int age){
        return userMapper.insertUser(id,name, age);
    }

    public int DeleteUser(int id){
        return userMapper.DeleteUser(id);
    }

    public int UpdateUser(int id,String name,int age){
        return userMapper.UpdateUser(id,name, age);
    }

    public Person login(String name, int age) {
        return userMapper.login(name,age);
    }

    public Person selectUsers(Person person){
        return userDao.selectUsers(person);
    }



}