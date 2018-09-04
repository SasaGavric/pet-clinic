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
        owner2.setId(2L);
        owner2.setFirstName("John");
        owner2.setLastName("Doe");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Sam");
        owner3.setLastName("Axe");

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setId(4L);
        owner4.setFirstName("Fiona");
        owner4.setLastName("Glenanne");

        ownerService.save(owner4);

        System.out.println("Loading completed...");
    }
}
