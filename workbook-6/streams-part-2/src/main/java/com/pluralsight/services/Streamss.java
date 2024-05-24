package com.pluralsight.services;

import java.util.ArrayList;
import java.util.List;

public class Streamss {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

    }
}
