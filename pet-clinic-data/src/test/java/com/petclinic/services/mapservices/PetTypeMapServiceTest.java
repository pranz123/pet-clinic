/**
 * 
 */
package com.petclinic.services.mapservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.petclinic.model.PetType;

/**
 * JUnit for PetType Service
 * @author Pranjal
 *
 */
class PetTypeMapServiceTest {

	PetTypeMapService petTypeMapService;
	Long id = 1L;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		petTypeMapService = new PetTypeMapService();
		petTypeMapService.save(PetType.builder().id(id).build());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetTypeMapService#findAll()}.
	 */
	@Test
	void testFindAll() {
		Set<PetType> petTypeSet = petTypeMapService.findAll();
		assertEquals(1, petTypeSet.size());
		
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetTypeMapService#findById(java.lang.Long)}.
	 */
	@Test
	void testFindByIdLong() {
		PetType petType = petTypeMapService.findById(id);
		assertEquals(id, petType.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetTypeMapService#save(com.petclinic.model.PetType)}.
	 */
	@Test
	void testSavePetType() {
		Long id = 2L;
		PetType petType2 = PetType.builder().id(id).build();
		PetType petTypeSaved = petTypeMapService.save(petType2);
		assertEquals(id, petTypeSaved.getId());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetTypeMapService#delete(com.petclinic.model.PetType)}.
	 */
	@Test
	void testDeletePetType() {
		petTypeMapService.delete(petTypeMapService.findById(id));
		assertEquals(0, petTypeMapService.findAll().size());
	}

	/**
	 * Test method for {@link com.petclinic.services.mapservices.PetTypeMapService#deleteById(java.lang.Long)}.
	 */
	@Test
	void testDeleteByIdLong() {
		petTypeMapService.deleteById(id);
		assertEquals(0, petTypeMapService.findAll().size());
	}

}
