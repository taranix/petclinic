package com.sonalake.petclinic.repository.jpa;

import com.sonalake.petclinic.model.Visit;
import com.sonalake.petclinic.repository.VisitExtensionRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository
@Primary // Overriding JpaVetRepositoryImpl
public class JpaVisitExtensionRepositoryImpl extends JpaVisitRepositoryImpl implements VisitExtensionRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Visit> findVisitForDate(LocalDate visitDate) {
        Query query = this.em.createQuery("SELECT visit FROM Visit visit where visit.date = :date"); //where visit.date= :date
        query.setParameter("date", visitDate);
        return query.getResultList();
    }
}
