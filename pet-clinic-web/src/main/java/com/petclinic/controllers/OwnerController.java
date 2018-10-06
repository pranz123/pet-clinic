package com.petclinic.controllers;

import com.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/ownerIndex","/ownerIndex.html"})
    public String listOwner(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/ownerIndex";
    }

    @RequestMapping("/find")
    public String findOwner(){
        return "workinprogress";
    }
}
