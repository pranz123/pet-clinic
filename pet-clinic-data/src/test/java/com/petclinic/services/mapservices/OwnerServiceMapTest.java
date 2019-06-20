package com.petclinic.services.mapservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.petclinic.model.Owner;

/**
 * JUnit Test for Owner Map Service
 * 
 * @author Pranjal
 *
 */
class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	
	final Long ownerId = 1L;
	final String lastName = "Kumar";
	
	@BeforeEach
	void setup() {
		ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}
	
	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerServiceMap.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void saveExistingId() {
		Long id = 2L;
		Owner owner2 = Owner.builder().id(id).build();
		Owner saveOwner = ownerServiceMap.save(owner2);
		assertEquals(id, saveOwner.getId());
	}
	
	@Test
	void saveNoid() {
		Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner kumar = ownerServiceMap.findByLastName(lastName);
		assertNotNull(kumar);
		assertEquals(ownerId, kumar.getId());
		assertEquals(lastName, kumar.getLastName());
	}

}
