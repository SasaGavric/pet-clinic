package com.sasagavric.petclinic.controller;

import com.sasagavric.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @GetMapping({"", "/", "/owners", "/owners.html"})
    public String listOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());



        return "owner/owners";
    }

    @GetMapping("/find")
    public String findOwners(){
        return "notImplemented";
    }

}
