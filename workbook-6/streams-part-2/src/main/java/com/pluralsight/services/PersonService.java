package com.pluralsight.services;

import com.pluralsight.models.Employee;
import com.pluralsight.models.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService
{

    public List<Person> findPeople(List<Person> people, String name)
    {
        return people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(name))
                .toList();
    }

    public List<Person> findPeople(List<Person> people, int age)
    {
        return people.stream()
                .filter(person -> person.getAge() == age)
                .toList();
    }

    public int calculateAverageAge(List<Person> people)
    {
        int averageAge = people.stream()
                .map(Person::getAge)// mapping person to it's age
                .reduce(0, (x,y) -> x+y); // starting with zero and adding each person's age

        return averageAge / people.size(); // dividing age by lists size
    }

    public int findOldestAge(List<Person> people)
    {
        return people.stream()
                .map(Person::getAge) // mapping person to it's age
                .max(Comparator.naturalOrder()) // comparing the age and checking if it's the max
                .orElse(0);
    }

    public int findYoungestAge(List<Person> people)
    {
        return people.stream()
                .map(Person::getAge)// mapping person to its age
                .min(Comparator.naturalOrder()) // comparing person's age and getting minimum age in the list
                .orElse(0); // setting the least age to zero if the list is empty
    }

    public List<Person> sortYoungestFirst(List<Person> people)
    {
        return people.stream() // streaming list
                .sorted(Comparator.comparingInt(Person::getAge)) // sorting using the Comparator class
                .collect(Collectors.toList()); // converting stream to list
    }

    public List<Person> sortOldestFirst(List<Person> people)
    {
        return people.stream() // streaming list
                .sorted(Comparator.comparingInt(Person::getAge)) // sorting age in distance order
                .collect(Collectors.toList()) // changing stream to list
                .reversed(); // reversing list
    }

    public List<Employee> createEmployees(List<Person> people)
    {
        List<Employee> employees = people.stream()
                .map(person -> {
                   return new Employee(person.getFirstName(), person.getLastName(), person.getAge(), person.getAge() * 3000); // mapping person object and returning employee object
                })
                .toList();

        return employees;
    }
}
