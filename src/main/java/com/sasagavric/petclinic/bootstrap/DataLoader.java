package com.sasagavric.petclinic.bootstrap;

import com.sasagavric.petclinic.model.*;
import com.sasagavric.petclinic.service.OwnerService;
import com.sasagavric.petclinic.service.PetTypeService;
import com.sasagavric.petclinic.service.SpecialityService;
import com.sasagavric.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialitiesService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialitiesService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            System.out.println("Start loading...");

            loadOwnersAndPets();
            loadVets();

            System.out.println("Loading completed...");
        }

    }


    public void loadVets(){
        //Speciality
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");

        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");

       Speciality savedDentistry = specialitiesService.save(dentistry);

       //Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Joe");
        vet1.setLastName("Cole");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Marry");
        vet2.setLastName("Rodman");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
    }


    public void loadOwnersAndPets(){

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Venice Beach");
        owner1.setCity("Los Angeles");
        owner1.setTelephone("004412345432");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rusty");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Doe");
        owner2.setAddress("Venice Beach");
        owner2.setCity("Los Angeles");
        owner2.setTelephone("001241551521");

        Pet johnsPet = new Pet();
        mikesPet.setName("Kitty");
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner2);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(johnsPet);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Sam");
        owner3.setLastName("Axe");
        owner3.setAddress("Malibu");
        owner3.setCity("Los Angeles");
        owner3.setTelephone("004142124");

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setFirstName("Fiona");
        owner4.setLastName("Glenanne");
        owner4.setAddress("Malibu");
        owner4.setCity("Los Angeles");
        owner4.setTelephone("004142214142");

        ownerService.save(owner4);

    }
}
