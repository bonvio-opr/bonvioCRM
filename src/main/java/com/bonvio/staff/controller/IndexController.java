package com.bonvio.staff.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String methodLogin() {
        return "index";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String method403() {
        return "403";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String methodDashboard() {
        return "index";
    }

    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public String methodDeal() {
        return "index";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String methodTask() {
        return "index";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String methodContact() {
        return "index";
    }

    @PreAuthorize("hasRole('Черный')")
    @ResponseBody
    @RequestMapping(value = "/banana", method = RequestMethod.GET)
    public String getBanana() { return "ТОЛЬКО ДЛЯ ЧЕРНЫХ"; }

}