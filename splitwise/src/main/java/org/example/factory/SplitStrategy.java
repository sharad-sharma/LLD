package org.example.factory;

import org.example.entities.User;

import java.util.List;

public abstract class SplitStrategy {
    public double amount;
    public User paidBy;
    public List<User> users;

    public SplitStrategy(double amount, User paidBy, List<User> users) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.users = users;
    }

    public abstract void splitAmount();
}
