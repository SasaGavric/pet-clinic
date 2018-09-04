package com.sasagavric.petclinic.bootstrap;

import com.sasagavric.petclinic.model.Owner;
import com.sasagavric.petclinic.service.OwnerService;
import com.sasagavric.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Start loading...");

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("John");
        owner1.setLastName("Doe");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner1.setId(3L);
        owner1.setFirstName("Sam");
        owner1.setLastName("Axe");

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner1.setId(4L);
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");

        ownerService.save(owner3);

        System.out.println("Loading completed...");
    }
}
