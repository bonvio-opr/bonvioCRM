package com.bonvio.staff.controller;

import com.bonvio.staff.controller.generic.GenericController;
import com.bonvio.staff.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by igorjan on 09.02.16.
 * Banana
*/

@Controller
@RequestMapping("/user")
public class UserController extends GenericController<User> {}
