package com.sonalake.petclinic.repository;

import com.sonalake.petclinic.model.Vet;
import com.sonalake.petclinic.model.Visit;

import java.time.LocalDate;
import java.util.List;

public interface VisitExtensionRepository extends VisitRepository {
    List<Visit> findVisitForDate(LocalDate var1);
}
