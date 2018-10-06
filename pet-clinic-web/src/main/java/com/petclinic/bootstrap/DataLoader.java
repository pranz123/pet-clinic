package com.petclinic.bootstrap;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.model.PetType;
import com.petclinic.model.Vet;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetService;
import com.petclinic.services.PetTypeService;
import com.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        //PetType Data
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Pet Type Loaded");

        //Owner Data
        Owner owner1 = new Owner();
        owner1.setFirstName("Pranjal");
        owner1.setLastName("Kumar");
        owner1.setAddress("Amanora");
        owner1.setCity("Pune");
        owner1.setTelephone("12345");

        Pet dogPet = new Pet();
        dogPet.setOwner(owner1);
        dogPet.setPetType(savedDogType);
        dogPet.setBirthDate(LocalDate.now());
        dogPet.setName("Doggy Pet ");
        owner1.getPets().add(dogPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Test");
        owner2.setLastName("Last Name");
        owner2.setAddress("Amanora");
        owner2.setCity("Pune");
        owner2.setTelephone("12345");

        Pet catPet = new Pet();
        catPet.setPetType(savedCatType);
        catPet.setOwner(owner2);
        catPet.setBirthDate(LocalDate.now());
        catPet.setName("Catty Pet");
        owner2.getPets().add(catPet);
        ownerService.save(owner2);

        System.out.println("Owner data loaded");

        //Vet Data
        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1");
        vet1.setLastName("Last1");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2");
        vet2.setLastName("Last2");
        vetService.save(vet2);

        System.out.println("Vet data loaded");
    }
}
