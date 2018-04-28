package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.RedisConfig;
import com.example.demo.model.Person;
import com.example.demo.service.UserService;
import com.example.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

        userService.testRedis(util);

        System.out.println(util.get("p1"));

        Person person=(Person) util.get("p1");
        System.out.println(person.getId()+"-"+person.getName());

        System.out.println(util.lGet("persons",0,5));
        Iterator iter=util.lGet("persons",0,5).iterator();
        while (iter.hasNext()){
            Person p=(Person) iter.next();
            System.out.println(p.getId()+"--"+p.getName()+"--"+p.getAge());
        }

        Map<String,Object> map=new HashMap<>();
        map.put("name","德玛西亚");
        map.put("area","班德尔城");
        util.hmset("hero",map);

        System.out.println(util.hget("hero","name"));
        System.out.println(util.hmget("hero"));
        Map hero=util.hmget("hero");
        System.out.println(hero.get("name")+"-"+hero.get("area"));


        util.sSet("work","射手","刺客","战士","法师","坦克");
        System.out.println(util.sGet("work"));
        Iterator work=util.sGet("work").iterator();
        while (work.hasNext()){
            System.out.println(work.next());
        }

        System.out.println(util.lGet("pp",0,5));
        List list=util.lGet("pp",0,5);
        List<Person> list1=(List<Person>) list.get(0);
        for(Person p:list1){
            System.out.println(p.getId()+"--"+p.getName()+"--"+p.getAge());
        }

        return n;

    }

}
