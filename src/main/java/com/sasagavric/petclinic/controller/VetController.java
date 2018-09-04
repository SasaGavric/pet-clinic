package com.sasagavric.petclinic.controller;

import com.sasagavric.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vet")
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", "/", "/vets", "/vets.html"})
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vet/vets";
    }


}
