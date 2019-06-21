/**
 * 
 */
package com.petclinic.services.mapservices;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.model.Visit;

/**
 * Junit for Visit Map Service
 * @author pranjal.a.kumar
 *
 */
class VisitServiceMapTest {

	VisitServiceMap visitServiceMap;
	Long id = 1L;
	Pet pet = Pet.builder().id(id).name("Romeo").owner(Owner.builder().id(id).build()).build();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		visitServiceMap = new VisitServiceMap();
		visitServiceMap.save(Visit.builder().id(id).pet(pet).build());
		
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VisitServiceMap#findAll()}.
	 */
	@Test
	void testFindAll() {
		Set<Visit> visitSet = visitServiceMap.findAll();
		assertEquals(1, visitSet.size());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VisitServiceMap#findById(java.lang.Long)}.
	 */
	@Test
	void testFindByIdLong() {
		Visit visit = visitServiceMap.findById(id);
		assertEquals(id, visit.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VisitServiceMap#save(com.petclinic.model.Visit)}.
	 */
	@Test
	void testSaveVisit() {
		Long id = 2L;
		Visit visit = visitServiceMap.save(Visit.builder().id(id).pet(pet).build());
		assertEquals(id, visit.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VisitServiceMap#delete(com.petclinic.model.Visit)}.
	 */
	@Test
	void testDeleteVisit() {
		visitServiceMap.delete(visitServiceMap.findById(id));
		assertEquals(0, visitServiceMap.findAll().size());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VisitServiceMap#deleteById(java.lang.Long)}.
	 */
	@Test
	void testDeleteByIdLong() {
		visitServiceMap.deleteById(id);
		assertEquals(0, visitServiceMap.findAll().size());
	}

}
