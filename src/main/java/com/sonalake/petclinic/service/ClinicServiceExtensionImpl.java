package com.sonalake.petclinic.service;

import com.sonalake.petclinic.model.Vet;
import com.sonalake.petclinic.model.Visit;
import com.sonalake.petclinic.repository.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Primary
public class ClinicServiceExtensionImpl extends ClinicServiceImpl implements ClinicServiceExtension {

    private VisitExtensionRepository visitExtensionRepository;

    public ClinicServiceExtensionImpl(PetRepository petRepository, VetRepository vetRepository, OwnerRepository ownerRepository, VisitExtensionRepository visitExtensionRepository) {
        super(petRepository, vetRepository, ownerRepository, visitExtensionRepository);
        this.visitExtensionRepository = visitExtensionRepository;

    }

    @Override
    public List<Vet> findVetsWithVisitForDate(LocalDate visitDate) {
        // Gettting Visit object which take place at visitDate
        List<Visit> visitsAsDate = visitExtensionRepository.findVisitForDate(visitDate);
        //Get distinct vet assigned to visists
        Set<Vet> vetsWithVisitAsDate = visitsAsDate.stream().map(i -> i.getVet()).collect(Collectors.toSet());
        // Each vet has reference to all visits and we need to filter the,
        for (Vet vet : vetsWithVisitAsDate){
            vet.setVisits( vet.getVisits().stream().filter(i ->i.getDate().equals(visitDate)).collect(Collectors.toSet()) );
        }

        return vetsWithVisitAsDate.stream().collect(Collectors.toList());
    }
}
