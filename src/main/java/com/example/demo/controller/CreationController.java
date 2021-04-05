package com.example.demo.controller;

import com.example.demo.model.InsuredObject;
import com.example.demo.model.Policy;
import com.example.demo.service.InsuredObjService;
import com.example.demo.service.PolicyService;
import com.example.demo.service.PolicyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
public class CreationController {

    private final PolicyService service;

    private final PolicyTypeService policyTypeService;

    private final InsuredObjService insuredObjService;

    @Autowired
    public CreationController(PolicyService service, PolicyTypeService policyTypeService, InsuredObjService insuredObjService) {
        this.service = service;
        this.policyTypeService = policyTypeService;
        this.insuredObjService = insuredObjService;
    }


    @GetMapping("/creationForm")
    public ModelAndView getCreationForm(@RequestParam("insured_obj") Long insuredObjId) {
        ModelAndView modelAndView = new ModelAndView("creationForm");
        InsuredObject insuredObject = insuredObjService.getObject(insuredObjId);
        modelAndView.addObject("policyTypes",
                insuredObject.getPolicyTypes());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createPolicy(@ModelAttribute @Valid Policy policy, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            handleFormErrors(policy, modelAndView);
            return modelAndView;
        }
        service.create(policy);
        modelAndView.setViewName("redirect:/policies");
        return modelAndView;
    }

    private void handleFormErrors(@ModelAttribute @Valid Policy policy, ModelAndView modelAndView) {
        modelAndView.addObject("policy", policy);
        modelAndView.addObject("policyTypes",
                policyTypeService.getPolicyTypes(policy.getInsuredObject().getId()));
        modelAndView.setViewName("creationForm");
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView handleNoSuchElementException(){
        return new ModelAndView("errorPage");
    }
}
