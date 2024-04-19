package com.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Intro to Arrays");
        int[] numbers = new int[6];
        String[] names;

        numbers[0] = 2;
        numbers[1] = 7;
        numbers[2] = 8;
        numbers[3] = 2;
        numbers[4] = 10;
        numbers[5] = 5;

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // creating array of objects
        Person[] people = {
                new Person("Alice", "Smith", 25),
                new Person("Joe", "Jones", 18),
                new Person("Emily","Martinez", 40)
        };

        for (int i = 0; i < people.length; i++){
            System.out.println(people[i].getFirstName() + " is " + people[i].getAge()  + " years old.");
        }

        //System.out.println(people);
    }
}