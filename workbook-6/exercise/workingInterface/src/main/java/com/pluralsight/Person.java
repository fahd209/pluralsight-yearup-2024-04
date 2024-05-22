package com.pluralsight;

public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person)
    {
        if(this.age != person.age) {
            return this.lastName.compareTo(person.lastName);
        }
        else if(!this.lastName.equals(person.lastName))
        {
            return this.lastName.compareTo(person.lastName);
        }

        return this.firstName.compareTo(person.lastName);
    }

    public String toString()
    {
        return String.format(" %s , %s , %d", this.getFirstName(), this.getLastName(), this.age);
    }
}
