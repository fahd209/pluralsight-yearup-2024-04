package com.pluralsight.services;

import com.pluralsight.models.Employee;
import com.pluralsight.models.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonService
{

    public List<Person> findPeople(List<Person> people, String name)
    {
        List<Person> personByName = new ArrayList<>();
        for (Person person : people)
        {
            if (person.getFirstName().equalsIgnoreCase(name))
            {
                personByName.add(person);
            }
        }
        return personByName;
    }

    public List<Person> findPeople(List<Person> people, int age)
    {
        List<Person> peopleByAge = new ArrayList<>();

        for (Person person : people)
        {
            if(person.getAge() == age)
            {
                peopleByAge.add(person);
            }
        }
        return peopleByAge;
    }

    public int calculateAverageAge(List<Person> people)
    {
        int peopleCount = people.size();
        int totalAge = 0;
        for (Person person : people)
        {
            totalAge += person.getAge();
        }

        return totalAge / peopleCount;
    }

    public int findOldestAge(List<Person> people)
    {
        int oldestAge = Integer.MIN_VALUE;

        for(Person person : people)
        {
            oldestAge = Math.max(oldestAge, person.getAge());
        }

        return oldestAge;
    }

    public int findYoungestAge(List<Person> people)
    {
        int youngestAge = Integer.MAX_VALUE;

        for (Person person : people)
        {
            youngestAge = Math.min(youngestAge, person.getAge());
        }

        return youngestAge;
    }

    public List<Person> sortYoungestFirst(List<Person> people)
    {
        List<Person> youngestFirst = people;

        Collections.sort(youngestFirst);

        return youngestFirst;
    }

    public List<Person> sortOldestFirst(List<Person> people)
    {
        List<Person> oldestFirst = sortYoungestFirst(people);

        return oldestFirst.reversed();
    }

    public List<Employee> createEmployees(List<Person> people)
    {
        List<Employee> employees = new ArrayList<>();

        for (Person person : people)
        {
            Employee employee = new Employee(person.getFirstName(), person.getLastName(), person.getAge(), person.getAge() * 3000);
            employees.add(employee);
        }
        return employees;
    }
}
