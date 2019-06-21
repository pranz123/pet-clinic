/**
 * 
 */
package com.petclinic.services.mapservices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.petclinic.model.Vet;

/**
 * Junit class for Vet Map Service
 * @author pranjal.a.kumar
 *
 */
class VetServiceMapTest {

	VetServiceMap vetServiceMap;
	Long id = 1L;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		vetServiceMap = new VetServiceMap(new SpecialityMapService());
		vetServiceMap.save(Vet.builder().id(id).build());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VetServiceMap#findAll()}.
	 */
	@Test
	void testFindAll() {
		Set<Vet> vetSet = vetServiceMap.findAll();
		assertEquals(1, vetSet.size());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VetServiceMap#findById(java.lang.Long)}.
	 */
	@Test
	void testFindByIdLong() {
		Vet vet = vetServiceMap.findById(id);
		assertEquals(id, vet.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VetServiceMap#save(com.petclinic.model.Vet)}.
	 */
	@Test
	void testSaveVet() {
		Long id = 2L;
		Vet savedVet = vetServiceMap.save(Vet.builder().id(id).build());
		assertEquals(id, savedVet.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VetServiceMap#delete(com.petclinic.model.Vet)}.
	 */
	@Test
	void testDeleteVet() {
		vetServiceMap.delete(vetServiceMap.findById(id));
		assertEquals(0, vetServiceMap.findAll().size());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.VetServiceMap#deleteById(java.lang.Long)}.
	 */
	@Test
	void testDeleteByIdLong() {
		vetServiceMap.deleteById(id);
		assertEquals(0, vetServiceMap.findAll().size());
	}

}
