package org.example;

import org.example.entities.BalanceSheet;
import org.example.entities.User;
import org.example.enums.SplitType;
import org.example.services.SplitwiseService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // lets create 4 users
        User user1 = new User("1", "user1", "user1@amazon.com", 123);
        User user2 = new User("2", "user2", "user2@amazon.com", 123);
        User user3 = new User("3", "user3", "user3@amazon.com", 123);
        User user4 = new User("4", "user4", "user4@amazon.com", 123);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        // now let's create Balance Sheet
        BalanceSheet balanceSheet = new BalanceSheet(users);

        // create Splitwise service with above users and balance sheet
        SplitwiseService service = new SplitwiseService(users, balanceSheet);

        service.printBalance();
        // Now let's perform few transactions
        service.addExpense(user1, 100, SplitType.EQUAL, List.of(user2, user3), null);
        service.printBalance();

        service.addExpense(user2, 100, SplitType.EXACT, List.of(user1, user3), List.of(30.0, 70.0));
        service.printBalance();

        service.addExpense(user4, 100, SplitType.PERCENT, List.of(user1, user2, user3),
                List.of(30.0, 30.0, 40.0));
        service.printBalance();

    }
}

/*
* It should first create all users
* create balance sheet
* then setup splitwise Service of all the above users
* */