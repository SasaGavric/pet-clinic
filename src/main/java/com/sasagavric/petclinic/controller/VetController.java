package com.sasagavric.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    @GetMapping({"/vets", "/vet/vets", "/vet/vets.html"})
    public String listVets(){
        return "vet/vets";
    }


}
