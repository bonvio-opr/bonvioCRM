package com.bonvio.staff.controllers;

import com.bonvio.staff.models.User;
import com.bonvio.staff.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mil on 04.06.15.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String main() {
        return "user";
    }

    @Autowired
    private UserService userService;

    /*@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }
*/
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    /*@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Integer getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        System.out.println(user + "вот такой юзер");
        return id;
    }
*/

    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Integer getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        System.out.println(user + "вот такой юзер");
        return id;
    }

    @RequestMapping(value = "/api/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return id;
    }

/*    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ResponseBody
    public User insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return user;
    }

    @RequestMapping(value = "/deleteUser/", method = RequestMethod.PUT)
    @ResponseBody
    public User deleteUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

    @RequestMapping(value = "deleteUserById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return id;
    }*/

}
