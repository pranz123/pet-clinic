package com.petclinic.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping({"/owners","/owners/ownerIndex","/owners/ownerIndex.html"})
    public String listOwner(){
        return "owners/ownerIndex";
    }
}
