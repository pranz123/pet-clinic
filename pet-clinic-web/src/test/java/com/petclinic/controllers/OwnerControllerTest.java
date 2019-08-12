package com.petclinic.controllers;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.petclinic.model.Owner;
import com.petclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController ownerController;
	
	Set<Owner> ownerSet;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		
		ownerSet = new HashSet<>();
		ownerSet.add(Owner.builder().id(1L).build());
		ownerSet.add(Owner.builder().id(2L).build());
		
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	@Test
	void testListOwner() throws Exception {
		when(ownerService.findAll()).thenReturn(ownerSet);	
		mockMvc.perform(get("/owners"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/ownerIndex"))
			.andExpect(model().attribute("owners", Matchers.hasSize(2)));
	}

	@Test
	void testFindOwner() throws Exception {
		mockMvc.perform(get("/owners/find"))
		.andExpect(status().isOk())
		.andExpect(view().name("workinprogress"));
		
		verifyZeroInteractions(ownerService);
	}
	
	@Test
    public void testShowOwner() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(get("/owners/123"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/ownerDetails"))
            .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }

}
