package com.sonalake.petclinic.service;

import com.sonalake.petclinic.model.Vet;
import com.sonalake.petclinic.model.Visit;

import java.time.LocalDate;
import java.util.List;

public interface ClinicServiceExtension extends ClinicService {
    public List<Vet> findVetsWithVisitForDate(LocalDate visitDate);
}
