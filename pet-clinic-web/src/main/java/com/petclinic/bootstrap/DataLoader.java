package com.petclinic.bootstrap;

import com.petclinic.model.Owner;
import com.petclinic.model.Vet;
import com.petclinic.services.OwnerService;
import com.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Pranjal");
        owner1.setLastName("Kumar");

        ownerService.save(owner1.getId(), owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Test");
        owner2.setLastName("Last Name");

        ownerService.save(owner2.getId(), owner2);

        System.out.println("Owner data loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vet1");
        vet1.setLastName("Last1");

        vetService.save(vet1.getId(), vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Vet2");
        vet2.setLastName("Last2");

        vetService.save(vet2.getId(), vet2);

        System.out.println("Vet data loaded");

    }
}
