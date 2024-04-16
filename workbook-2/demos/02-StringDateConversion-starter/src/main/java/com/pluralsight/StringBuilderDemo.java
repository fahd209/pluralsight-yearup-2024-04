package com.pluralsight;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder skills = new StringBuilder();

        skills.append("Java, ");
        skills.append("CSS, ");
        skills.append("Javascript, ");
        skills.append("Python. ");

        System.out.println(skills);

    }
}
