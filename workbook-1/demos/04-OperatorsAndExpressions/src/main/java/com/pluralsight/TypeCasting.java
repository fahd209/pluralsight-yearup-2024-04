package com.pluralsight;

public class TypeCasting
{
    public static void main(String[] args)
    {
        // variable widening
        // a smaller data type variable can always put into a bigger data type
        int intValue = 9;
        long longValue;

        float floatValue = 3.8f;
        double doubleValue;

        // an int fits in a long
        longValue = intValue;

        // a float fits in a double
        doubleValue = floatValue;

        // you can even put an int or long into a float or double
        floatValue = longValue;
        doubleValue = longValue;



        // variable narrowing
        // a larger data type variable cannot automatically be stored in a smaller data type
        int myInt;
        long myLong = 9;

        float myFloat;
        double myDouble = 123.4567890123;

        // an int won't necessarily fit in a long, unless you convert it into an int (int)
         myInt = (int) myLong;
        System.out.println("Int "+myInt);

        // a double won't necessarily fit in a float, unless you convert it to a float
         myFloat = (float) myDouble;
        System.out.println("Float "+myFloat);
        // a float probably won't necessarily fit in an int, unless you convert it to an long (long)
         myLong = (long) myFloat;
        System.out.println("Long "+myLong);

    }
}
