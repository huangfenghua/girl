package com.hfh.girl.controller;

import com.hfh.girl.entity.Person;
import com.hfh.girl.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/HelloUsers")
    public String HelloUsers (){
        return "hello";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "index";
    }

    @RequestMapping("/login.html")
    public String login(@Param("name") String name,@Param("age")int age){
         if(userService.login(name,age)!= null){
             System.out.print("优质");
         }
        return "hello";
    }
    @RequestMapping("/helloUser/{id}")
    public String selectUser (@PathVariable int id){
        return userService.selectUser(id).toString();
    }

    @RequestMapping("/insertUser/{id}/{name}/{age}")
    public int InsertUser (@PathVariable(value = "id") int id,@PathVariable(value = "name") String name,@PathVariable(value = "age") int age){
        return userService.InsertUser(id,name, age);
    }

    @RequestMapping("/DeleteUser/{id}")
    public int DeleteUser (@PathVariable int id){
        if(userService.DeleteUser(id)>1){
            return  1;
        } else {
            return 0;
        }
    }

    @RequestMapping("/UpdateUser/{id}/{name}/{age}")
    public int UpdateUser(@PathVariable(value = "id") int id,@PathVariable(value = "name") String name,@PathVariable(value = "age") int age){
        return userService.UpdateUser(id,name, age);
    }
    @RequestMapping("/logins.html")
    public String selectUsers(Person person){

        if(userService.selectUsers(person)!= null){
            System.out.print("优质");
        }
        return "hello";
    }
}