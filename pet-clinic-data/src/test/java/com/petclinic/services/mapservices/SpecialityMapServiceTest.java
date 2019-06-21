/**
 * 
 */
package com.petclinic.services.mapservices;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.petclinic.model.Speciality;

/**
 * Junit for Speciality Map Service
 * @author pranjal.a.kumar
 *
 */
class SpecialityMapServiceTest {

	SpecialityMapService specialityMapService;
	Long id = 1L;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		specialityMapService = new SpecialityMapService();
		specialityMapService.save(Speciality.builder().id(id).build());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.SpecialityMapService#findAll()}.
	 */
	@Test
	void testFindAll() {
		Set<Speciality> specialitySet = specialityMapService.findAll();
		assertEquals(1, specialitySet.size());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.SpecialityMapService#findById(java.lang.Long)}.
	 */
	@Test
	void testFindByIdLong() {
		Speciality speciality = specialityMapService.findById(id);
		assertEquals(id, speciality.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.SpecialityMapService#save(com.petclinic.model.Speciality)}.
	 */
	@Test
	void testSaveSpeciality() {
		Long id = 2L;
		Speciality savedSpeciality = specialityMapService.save(Speciality.builder().id(id).build());
		assertEquals(id, savedSpeciality.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.SpecialityMapService#delete(com.petclinic.model.Speciality)}.
	 */
	@Test
	void testDeleteSpeciality() {
		specialityMapService.delete(specialityMapService.findById(id));
		assertEquals(0, specialityMapService.findAll().size());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.SpecialityMapService#deleteById(java.lang.Long)}.
	 */
	@Test
	void testDeleteByIdLong() {
		specialityMapService.deleteById(id);
		assertEquals(0, specialityMapService.findAll().size());
	}

}
