/**
 * 
 */
package com.petclinic.services.mapservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.petclinic.model.Pet;

/**
 * JUnit for PetService
 * @author Pranjal
 *
 */
class PetServiceMapTest {

	PetServiceMap petServiceMap;
	Long id = 1L;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		petServiceMap = new PetServiceMap();
		petServiceMap.save(Pet.builder().id(id).build());
		
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetServiceMap#findAll()}.
	 */
	@Test
	void testFindAll() {
		Set<Pet> petSet = petServiceMap.findAll();
		assertEquals(1, petSet.size());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetServiceMap#findById(java.lang.Long)}.
	 */
	@Test
	void testFindByIdLong() {
		Pet pet = petServiceMap.findById(id);
		assertEquals(id, pet.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetServiceMap#save(com.petclinic.model.Pet)}.
	 */
	@Test
	void testSavePet() {
		Long id = 3L;
		Pet pet2 = Pet.builder().id(id).build();
		Pet savePet = petServiceMap.save(pet2);
		assertEquals(id, savePet.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetServiceMap#delete(com.petclinic.model.Pet)}.
	 */
	@Test
	void testDeletePet() {
		petServiceMap.delete(petServiceMap.findById(id));
		assertEquals(0, petServiceMap.findAll().size());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetServiceMap#deleteById(java.lang.Long)}.
	 */
	@Test
	void testDeleteByIdLong() {
		petServiceMap.deleteById(id);
		assertEquals(0, petServiceMap.findAll().size());
	}

}
