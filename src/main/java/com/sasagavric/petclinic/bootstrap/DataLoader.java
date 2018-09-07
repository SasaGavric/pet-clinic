package com.sasagavric.petclinic.bootstrap;

import com.sasagavric.petclinic.model.Owner;
import com.sasagavric.petclinic.model.PetType;
import com.sasagavric.petclinic.model.Vet;
import com.sasagavric.petclinic.service.OwnerService;
import com.sasagavric.petclinic.service.PetTypeService;
import com.sasagavric.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start loading...");

        loadOwnersAndPets();
        loadVets();

        System.out.println("Loading completed...");

    }


    public void loadVets(){
        Vet vet1 = new Vet();
        vet1.setFirstName("Joe");
        vet1.setLastName("Cole");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Marry");
        vet2.setLastName("Rodman");

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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Doe");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Sam");
        owner3.setLastName("Axe");

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setFirstName("Fiona");
        owner4.setLastName("Glenanne");

        ownerService.save(owner4);

    }
}
