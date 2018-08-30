package com.sasagavric.petclinic.service;

import com.sasagavric.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById (long id);

    Pet save(Pet owner);

    Set<Pet> findAll();

}
