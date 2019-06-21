package com.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Visit POJO
 * 
 * @author Pranjal
 *
 */
@Data
@EqualsAndHashCode(exclude = {"pet"})
@Entity
@Table(name = "visits")
@NoArgsConstructor
public class Visit extends BaseEntity {

    @Column(name = "visit_date")
    private LocalDate date;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    
    @Builder
    Visit(Long id, LocalDate date, String description, Pet pet){
    	super(id);
    	this.date = date;
    	this.description = description;
    	if(null != pet) {
    		this.pet = pet;
    	}
    }

}
