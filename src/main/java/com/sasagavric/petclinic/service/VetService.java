package com.sasagavric.petclinic.service;

import com.sasagavric.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById (long id);

    Vet save(Vet owner);

    Set<Vet> findAll();

}
