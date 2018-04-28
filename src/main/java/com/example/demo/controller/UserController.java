package com.example.demo.controller;

import com.example.demo.config.RedisConfig;
import com.example.demo.model.Person;
import com.example.demo.service.UserService;
import com.example.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yinxf on 2018/4/18.
 */
@Controller
public class UserController {
    @Autowired
    public UserService  userService;

    @Autowired
    private RedisConfig redisConfig;

    @RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    String index(ModelMap modelMap){


        modelMap.put("user","张三");
        return "index";

    }

    @RequestMapping(value ="/showUser", method = RequestMethod.GET)
    @ResponseBody
    public String selectUser (){
        Person person=userService.selectUser(1);
        String name=person.getName();

        return name;

    }

    @RequestMapping(value ="/showRedisUser", method = RequestMethod.GET)
    @ResponseBody
    public String showRedisUser (String name){
        RedisUtil util = redisConfig.getRedisUtil();
        util.del(name);
        util.set(name, "张思");

        String n=util.get(name).toString();

        return n;

    }

}
