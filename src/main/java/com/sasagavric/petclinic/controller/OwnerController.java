package com.sasagavric.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    @GetMapping({"", "/", "/owners", "/owners.html"})
    public String ownerPage(){
        return "owner/owners";
    }

}
