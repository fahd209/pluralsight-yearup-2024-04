package com.pluralsight.finance;

import com.pluralsight.finance.interfaces.Valuable;

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Fahd", "1234", 5000);
        Valuable account2 = new BankAccount("Omar", "3214", 4000);

        account1.deposit(100);
    }
}
