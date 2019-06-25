/**
 * 
 */
package com.petclinic.services.jpaservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.petclinic.model.Owner;
import com.petclinic.repositories.OwnerRepository;

/**
 * @author pranjal.a.kumar
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

	@Mock
	OwnerRepository ownerRepository;

	@InjectMocks
	OwnerJPAService ownerJPAService;

	String LAST_NAME = "kumar";
	
	Owner returnOwner;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
		
	}

	/**
	 * Test method for
	 * {@link com.petclinic.services.jpaservices.OwnerJPAService#findByLastName(java.lang.String)}.
	 */
	@Test
	void testFindByLastName() {

		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

		Owner kumar = ownerJPAService.findByLastName(LAST_NAME);

		assertEquals(LAST_NAME, kumar.getLastName());

		verify(ownerRepository).findByLastName(any());
	}

	/**
	 * Test method for
	 * {@link com.petclinic.services.jpaservices.OwnerJPAService#findAll()}.
	 */
	@Test
	void testFindAll() {
		Set<Owner> returnOwnerSet = new HashSet<>();
		returnOwnerSet.add(Owner.builder().id(1L).build());
		returnOwnerSet.add(Owner.builder().id(2L).build());
		
		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
		
		Set<Owner> owners = ownerJPAService.findAll();
		
		assertNotNull(owners);
		assertEquals(2, owners.size());
		
	}

	/**
	 * Test method for
	 * {@link com.petclinic.services.jpaservices.OwnerJPAService#findById(java.lang.Long)}.
	 */
	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = ownerJPAService.findById(1L);
		assertNotNull(owner);
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner = ownerJPAService.findById(1L);
		assertNull(owner);
	}

	/**
	 * Test method for
	 * {@link com.petclinic.services.jpaservices.OwnerJPAService#save(com.petclinic.model.Owner)}.
	 */
	@Test
	void testSave() {
		Owner ownerToSave = Owner.builder().id(1L).build();
		
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		
		Owner ownerSaved = ownerJPAService.save(ownerToSave);
		
		assertNotNull(ownerSaved);
		
		verify(ownerRepository).save(any());
	}

	/**
	 * Test method for
	 * {@link com.petclinic.services.jpaservices.OwnerJPAService#delete(com.petclinic.model.Owner)}.
	 */
	@Test
	void testDelete() {
		ownerJPAService.delete(returnOwner);
		verify(ownerRepository).delete(any());
	}

	/**
	 * Test method for
	 * {@link com.petclinic.services.jpaservices.OwnerJPAService#deleteById(java.lang.Long)}.
	 */
	@Test
	void testDeleteById() {
		ownerJPAService.deleteById(1L);
		verify(ownerRepository).deleteById(anyLong());
	}

}
