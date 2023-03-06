package org.example.entities;

import org.example.factory.SplitStrategy;

public class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private SplitStrategy splitStrategy;

    public Expense(String id, double amount, User paidBy, SplitStrategy splitStrategy) {
        this.id = id;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitStrategy = splitStrategy;
    }

    public void performSplit() {
        splitStrategy.splitAmount();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", paidBy=" + paidBy +
                ", splitStrategy=" + splitStrategy +
                '}';
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public SplitStrategy getSplitStrategy() {
        return splitStrategy;
    }

    public void setSplitStrategy(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }
}
