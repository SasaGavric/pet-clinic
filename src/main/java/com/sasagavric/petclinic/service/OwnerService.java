package com.sasagavric.petclinic.service;

import com.sasagavric.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
