package com.pluralsight.services;

import com.pluralsight.models.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    // set up
    PersonService service = new PersonService();

    @Test
    public void findPeople_shouldReturn_a_ListPerson_withTheProvidedName()
    {
        // arrange
        List<Person> people = new ArrayList<>();
        people.add(new Person("Dana", "wyat", 65));
        people.add(new Person("Julian", "Gonzalez", 18));

        //act
        List<Person> actualPerson = service.findPeople(people, "Dana");
        Person person = actualPerson.getFirst();

        //assert
        assertTrue(people.contains(person), "Because find people should return the person with the name provided");
    }

    @Test
    public void findPeople_shouldReturn_aListOfAPersonWithTheProvidedAge()
    {
        //arrange
        List<Person> people = new ArrayList<>();
        people.add(new Person("Dana", "wyat", 65));
        people.add(new Person("Julian", "Gonzalez", 18));

        //act
        List<Person> actualPerson = service.findPeople(people, 18);
        Person person = actualPerson.getFirst();

        //assert
        assertTrue(people.contains(person), "Because findPeople() should return a person with the provided age");
    }

    @Test
    public void calculateAverageAge_shouldReturn_theAverageAgeOfPeopleInTheList()
    {
        //arrange
        List<Person> people = new ArrayList<>();
        people.add(new Person("Dana", "wyat", 65));
        people.add(new Person("Julian", "Gonzalez", 18));
        int expectedAverageAge = 41;

        //act
        int actualAverageAge = service.calculateAverageAge(people);

        //assert
        assertEquals(expectedAverageAge, actualAverageAge, "Because calculateAverageAge() should return the average of people.");
    }

    @Test
    public void findTheOldest_shouldReturn_theOldestAge_inThePeopleList()
    {
        //arrange
        List<Person> people = new ArrayList<>();
        people.add(new Person("Dana", "wyat", 65));
        people.add(new Person("Julian", "Gonzalez", 18));
        int expectedOldestAge = 65;

        //act
        int actualOldestAge = service.findOldestAge(people);

        //assert
        assertEquals(expectedOldestAge, actualOldestAge, "Because findTheOldest should return the oldest age in the peoples list");

    }

    @Test
    public void findTheYoungestAge_shouldReturn_theYoungestPersonAge()
    {
        //arrange
        List<Person> people = new ArrayList<>();
        people.add(new Person("Dana", "wyat", 65));
        people.add(new Person("Julian", "Gonzalez", 18));
        int expectedYoungestAge = 18;

        //act
        int actualYoungestAge = service.findYoungestAge(people);

        assertEquals(expectedYoungestAge, actualYoungestAge, "Because findTheYoungestAge() should return the youngest person in the people list");
    }

    @Test
    public void sortFromYoungest_shouldReturn_aListFromYoungestToOldest()
    {
        //arrange
        List<Person> people = new ArrayList<>();
        people.add(new Person("Dana", "wyat", 65));
        people.add(new Person("Julian", "Gonzalez", 18));
        

        //act

    }
}