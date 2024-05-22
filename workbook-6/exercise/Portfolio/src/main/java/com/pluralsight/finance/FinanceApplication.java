package com.pluralsight.finance;

import com.pluralsight.finance.interfaces.Valuable;

import java.util.ArrayList;
import java.util.List;

public class FinanceApplication {
    public void run(){
        Portfolio myPortfolio = new Portfolio("Assets", "Fahd");

        myPortfolio.add(new BankAccount("Chase", "14526", 5000));
        myPortfolio.add(new House("My house", 180, 2015, 5000, 5));
        myPortfolio.add(new Jewelry("Diamonds", 200, 50));
        myPortfolio.add(new Gold("My gold", 42, 150));

        List<Valuable> myAsset = myPortfolio.getAssests();
        Valuable mostValuableAsset = myPortfolio.getMostValuable();

        System.out.println("My most valuable asset is: " + mostValuableAsset.toString());

        Valuable leastValuableAsset = myPortfolio.getLeastValuable();

        System.out.println();
        System.out.println("My least value asset: " + leastValuableAsset.toString());

        System.out.println();
        System.out.println("All my assets");
        for (Valuable asset : myAsset)
        {
            System.out.println(asset.toString());
        }
        System.out.println("My total portfolio value: " + myPortfolio.getValue());
    }
}
