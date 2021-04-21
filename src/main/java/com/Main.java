package com;

import com.model.Person;
import com.repo.PersonRepo;
import com.service.PersonService;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName ("org.h2.Driver");
        Person person1= new Person();
        Person person2= new Person();
        Person person3= new Person();


        person1.setName("nume1");
        person1.setEmail("email1@yahoo.com");
        person1.setDataAngajare(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        person1.setAge(30);

        person2.setName("nume2");
        person2.setEmail("email2@yahoo.com");
        person2.setDataAngajare(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        person2.setAge(302);

        person3.setName("nume3");
        person3.setEmail("email3@yahoo.com");
        person3.setDataAngajare(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        person3.setAge(33);

        PersonRepo personRepo = new PersonRepo();
        PersonService personService = new PersonService(personRepo);
        personService.createPerson(person1);
        personService.createPerson(person2);
        personService.createPerson(person3);

        Person person1new = new Person();
        person1new.setName(person1.getName());
        person1new.setEmail(person1.getEmail());
        person1new.setDataAngajare(person1.getDataAngajare());
        person1new.setAge(12);

        personService.updatePersonByName(person1, person1new);

        personService.deletePersonByName(person3);


        Person person4 = personService.findPersonByName(person2);
        System.out.println(person4.getAge());
    }
}
