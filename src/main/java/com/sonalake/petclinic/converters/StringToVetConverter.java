package com.sonalake.petclinic.converters;

import com.sonalake.petclinic.model.Vet;
import com.sonalake.petclinic.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToVetConverter implements Converter<String, Vet> {

    @Autowired
    private final ClinicService clinicService;

    @Autowired
    public StringToVetConverter(ClinicService clinicService) {
        System.out.println("******** " +this.getClass().getName() + " created..");
        this.clinicService = clinicService;
    }


    //Expecting VET ID
    @Override
    public Vet convert(String vetId) {
       Vet result =  clinicService.findVets().stream().filter(i -> i.getId().equals(Integer.parseInt(vetId))).findFirst().get(); //findVetById(Integer.parseInt(vetId));
       return result;
    }
}
