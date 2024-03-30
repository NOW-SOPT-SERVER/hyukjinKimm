package org.example;

import org.example.classes.Person;
import org.example.classes.PersonBuilder;

public class Main {
    public static void main(String[] args){

        Person person = new Person("도소현", 24, "female");
        person.walk();
        System.out.println(person.getName());
        System.out.println(person.getName()); //결과 : 도소현

        person.setName("서팟장");

        System.out.println(person.getName()); //결과 : 서팟장
        Person.run();

        Person personWithBuilder = new
                PersonBuilder()
                .name("도소현")
                .age(24)
                .sex("female")
                .build();
        Person personWithFactoryMethod = Person.create("도소현", 24, "female");

    }
}