package com.service;

import com.model.Person;
import com.repo.PersonRepo;

public class PersonService {

    private PersonRepo personRepo;


    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }


    public boolean createPerson(Person person){
        return personRepo.create(person);
    }



    public Person findPersonByName (Person person){
        return personRepo.findByName(person);

    }



    public boolean updatePersonByName (Person oldPerson, Person newPerson){
        return personRepo.updateByName(oldPerson, newPerson);

    }



    public boolean deletePersonByName (Person person){
        return personRepo.deleteByName(person);

    }
}
