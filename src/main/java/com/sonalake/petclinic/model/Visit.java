//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonalake.petclinic.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
@Table(
    name = "visits"
)
public class Visit extends BaseEntity {
    @Column(
        name = "visit_date"
    )
    @DateTimeFormat(
        pattern = "yyyy/MM/dd"
    )
    private LocalDate date = LocalDate.now();

    @Column(
            name = "visit_time"
    )
    @DateTimeFormat(
        iso = DateTimeFormat.ISO.TIME, pattern="HH:mm"
    )
    private LocalTime time = LocalTime.parse("09:00:00"); //default value

    @NotEmpty
    @Column(
        name = "description"
    )
    private String description;
    @ManyToOne
    @JoinColumn(
        name = "pet_id"
    )
    private Pet pet;

    @ManyToOne
    @JoinColumn(  name = "vet_id" )
    @XmlTransient // avoid cycle in graph during JAXB marshalling
    @JsonBackReference
    private Vet vet;

    public Visit() {
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
