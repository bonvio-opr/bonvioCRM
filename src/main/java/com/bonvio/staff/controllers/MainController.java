package com.bonvio.staff.controllers;

import com.bonvio.staff.models.User;
import com.bonvio.staff.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by niko on 03.06.15.
 */
@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    /*@Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }*/



}