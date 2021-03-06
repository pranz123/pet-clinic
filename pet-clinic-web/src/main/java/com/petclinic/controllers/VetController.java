package com.petclinic.controllers;

import com.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/vetIndex","/vets/vetIndex.html" ,"/vets.html"})
    public String listsVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/vetIndex";
    }
}