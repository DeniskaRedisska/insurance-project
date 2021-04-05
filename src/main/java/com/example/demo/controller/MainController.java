package com.example.demo.controller;

import com.example.demo.service.InsuredObjService;
import com.example.demo.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final PolicyService service;

    private final InsuredObjService insuredObjService;

    @Autowired
    public MainController(PolicyService service, InsuredObjService insuredObjService) {
        this.service = service;
        this.insuredObjService = insuredObjService;
    }

    @GetMapping("/policies")
    public ModelAndView getPolicies() {
        ModelAndView modelAndView = new ModelAndView("policyList");
        modelAndView.addObject("policies", service.getAllPolicies());
        return modelAndView;
    }



    @GetMapping("/insuredObjects")
    public ModelAndView getInsuredObjects() {
        ModelAndView modelAndView = new ModelAndView("policyCreationOptions");
        modelAndView.addObject("objects", insuredObjService.getObjects());
        return modelAndView;
    }

}
