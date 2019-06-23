package com.example.ssmspringboot.controller;



import com.alibaba.fastjson.JSONObject;
import com.example.ssmspringboot.domain.User;
import com.example.ssmspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
@Controller	//声明这是Controller层

public class UserController {


    //依赖注入
    @Autowired
    UserService userService;


    @RequestMapping(value="/login")
    @ResponseBody
    public User login(User user) {
        //调用dao层

        System.out.println("前端"+user);
        User u = userService.getUser(user.getUsername());
        System.out.println("数据库"+u);
        if (u.getPassword().equals(user.getPassword())){
            return u;
        }
        return null;
    }

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public JSONObject getAll(){
          ArrayList userList=userService.getAll();
          System.out.println(userList);
        JSONObject rootObject = new JSONObject();
        rootObject.put("code",0);
        rootObject.put("msg","");
        rootObject.put("count",1000);
        rootObject.put("data",userList);

        return rootObject;
    }

    @RequestMapping(value = "/getUserById")
    @ResponseBody
    public JSONObject getUserById(Integer id){
        System.out.println(id);
        User user = userService.getUserById(id);
        System.out.println(user);
        JSONObject rootObject = new JSONObject();
        rootObject.put("code",0);
        rootObject.put("msg","");
        rootObject.put("count",1000);
        rootObject.put("data",user);

        return rootObject;
    }
    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public  String delete(Integer id){
        User  user=new User();
        user.setId(id);

        String msg=userService.delete(id);
        return  msg;

    }
    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public ArrayList update(Integer id){
        User  user=new User();
        user.setId(id);
        user.setUsername("111");
        user.setPassword("111");
        user.setRole("www");
        ArrayList msg=userService.update(user);
        return  msg;

    }
    @RequestMapping(value = "/insertUser")
    @ResponseBody
    public String insert(User user){
        String msg="成功";
        userService.insert(user);

        return  msg;

    }
}
