package com.sonalake.petclinic.web;

import com.sonalake.petclinic.model.Vet;
import com.sonalake.petclinic.model.Visit;
import com.sonalake.petclinic.service.ClinicService;
import com.sonalake.petclinic.service.ClinicServiceExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Controller
public class WelcomeController {

    private final ClinicServiceExtension clinicService;

    @Autowired
    public WelcomeController(ClinicServiceExtension clinicService) {
        this.clinicService = clinicService;
    }

    @ModelAttribute("vets")
    List<Vet> getVisitForToday() {
        return this.clinicService.findVetsWithVisitForDate(LocalDate.now());
    }

    @RequestMapping(value = "/")
    public String welcomePage() {
        return "welcome";
    }
}
