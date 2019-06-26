package com.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * Visit POJO
 * 
 * @author Pranjal
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visits")
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
    
    public LocalDate getDate() {
        return date;
    }

}
