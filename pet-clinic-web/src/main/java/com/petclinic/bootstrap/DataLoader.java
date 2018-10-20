package com.petclinic.bootstrap;

import com.petclinic.model.*;
import com.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0){
            System.out.println("----------------Loading Data---------------");
            loadData();
            System.out.println("----------------Finish Loading Data---------------");
        }else{
            System.out.println("----------------Data Already Loaded---------------");
        }
    }

    private void loadData() {

        //PetType Data
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("--------------Pet Type Loaded-----------");

        //Specialities
        Speciality dentist = new Speciality();
        dentist.setDescription("Dentistry");
        Speciality savedDentist = specialityService.save(dentist);


        Speciality radilogist = new Speciality();
        dentist.setDescription("Radiology");
        Speciality savedRadilogist = specialityService.save(radilogist);

        Speciality surgeon = new Speciality();
        dentist.setDescription("Suregery");
        Speciality savedSurgeon = specialityService.save(surgeon);

        System.out.println("--------------Specialities Loaded-----------");

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

        System.out.println("-----------------Owner data loaded-----------------");

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(catPet);
        catVisit.setDescription("Cat Visit Description, smelly cat");

        System.out.println("-----------------Visit data loaded-----------------");

        //Vet Data
        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1");
        vet1.setLastName("Last1");
        vet1.getSpecialities().add(savedDentist);
        vet1.getSpecialities().add(savedSurgeon);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2");
        vet2.setLastName("Last2");
        vet1.getSpecialities().add(savedDentist);
        vet1.getSpecialities().add(savedRadilogist);
        vetService.save(vet2);

        System.out.println("---------------Vet data loaded--------------------");
    }
}
