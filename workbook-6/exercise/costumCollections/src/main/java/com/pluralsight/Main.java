package com.pluralsight;

public class Main {
    public static void main(String[] args)
    {
        FixedList<Integer> customList = new FixedList<>(2);
        customList.add(1);
        customList.add(2);
        customList.add(4); // <== this item doesn't get added
        System.out.println(customList.getItems());

        FixedList<Character> charactersList = new FixedList<>(3);
        charactersList.add('A');
        charactersList.add('B');
        charactersList.add('C');
        charactersList.add('D'); // this doesn't get added
        System.out.println(charactersList.getItems());
    }
}