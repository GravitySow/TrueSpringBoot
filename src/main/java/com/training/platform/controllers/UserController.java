package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo2")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/findByID")
    public Optional<User> findByID(@RequestParam String id){
        return userService.findById(Integer.parseInt(id));
    }

    @GetMapping(value = "/findAllByLimit")
    public Page<User> findAllByLimit(@RequestParam String start, @RequestParam String limit, @RequestParam String field){
        return userService.findAllByLimit(Integer.parseInt(start), Integer.parseInt(limit), field);
    }

    @GetMapping(value = "/findByCityAndActiveAndAge")
    public List<User> findByCityAndActiveAndAge(@RequestParam String city, @RequestParam String active, @RequestParam String age){
        return userService.findByCityAndActiveAndAge(city, Integer.parseInt(active), Integer.parseInt(age));
    }

    @GetMapping(value = "/findByAgeIn")
    public List<User> findByAgeIn(@RequestParam(name = "age") List<Integer> ageList){
//        String[] x = ages.split(",");
//        List<Integer> ageList = new ArrayList<Integer>();
//        for(String y:x){
//            ageList.add(Integer.parseInt(y));
//        }
        return userService.findByAgeIn(ageList);
    }

    @GetMapping(value = "/findAllByQuery")
    public List<User> findAllByQuery(){
        return  userService.findAllByQuery();
    }

    @GetMapping(value = "/findAllByParamsQuery")
    public List<User> findAllByParamsQuery(@RequestParam String active,@RequestParam String city){
        return userService.findAllByParamsQuery(Integer.parseInt(active), city);
    }

    @GetMapping(value = "/findAllByJpqlQuery")
    public List<User> findAllByJpqlQuery(){
        return userService.findAllByJpqlQuery();
    }

    @GetMapping(value = "/findAllByJpqlParamsQuery")
    public List<User> index(@RequestParam String active, @RequestParam String city) {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(Integer.parseInt(active), city);
    }

}
