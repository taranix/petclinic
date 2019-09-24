//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonalake.petclinic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(
    name = "vets"
)
public class Vet extends Person {
    @ManyToMany(
        fetch = FetchType.EAGER
    )
    @JoinTable(
        name = "vet_specialties",
        joinColumns = {@JoinColumn(
    name = "vet_id"
)},
        inverseJoinColumns = {@JoinColumn(
    name = "specialty_id"
)}
    )
    private Set<Specialty> specialties;

    @OneToMany(mappedBy = "vet", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Visit> visits;

    public Vet() {
    }

    protected Set<Specialty> getSpecialtiesInternal() {
        if (this.specialties == null) {
            this.specialties = new HashSet();
        }

        return this.specialties;
    }

    protected void setSpecialtiesInternal(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    @XmlElement
    public List<Specialty> getSpecialties() {
        List<Specialty> sortedSpecs = new ArrayList(this.getSpecialtiesInternal());
        PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedSpecs);
    }

    public int getNrOfSpecialties() {
        return this.getSpecialtiesInternal().size();
    }

    public void addSpecialty(Specialty specialty) {
        this.getSpecialtiesInternal().add(specialty);
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getFirstName());
        sb.append(" ");
        sb.append(getLastName());

        if(!getSpecialties().isEmpty()){
            sb.append(" (");
            sb.append(getSpecialties().stream().map(item -> item.getName()).collect(Collectors.joining(", ")));
            sb.append(")");
        }

        return sb.toString();


    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}
