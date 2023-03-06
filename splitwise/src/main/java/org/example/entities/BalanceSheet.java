package org.example.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheet {
    private Map<User, Map<User, Double>> balanceSheet;

    public BalanceSheet(List<User> users) {
        balanceSheet = new HashMap<>();
    }

    public void addTransaction(User paidBy, User paidTo, double amount) {
        // To avoid NPE
        addDummyTransaction(paidBy, paidTo);
        addDummyTransaction(paidTo, paidBy);

        Map<User, Double> sheet = balanceSheet.get(paidBy);
        Map<User, Double> sheetBackward = balanceSheet.get(paidTo);

        // Transaction history is owned by the user which paid most recently
        sheet.put(paidTo, sheet.get(paidTo) + amount - sheetBackward.get(paidBy));
        sheetBackward.put(paidBy, 0.0);

        if(sheet.get(paidTo) < 0) {
            sheetBackward.put(paidBy, -sheet.get(paidTo));
            sheet.put(paidTo, 0.0);
        }

        System.out.println("Transaction between " + paidBy.getName() + " and " +
                paidTo.getName() + " for amount = " + amount + " is successful");
    }

    private void addDummyTransaction(User paidBy, User paidTo) {
        if(!balanceSheet.containsKey(paidBy)) balanceSheet.put(paidBy, new HashMap<>());

        Map<User, Double> sheet = balanceSheet.get(paidBy);
        if(!sheet.containsKey(paidTo)) sheet.put(paidTo, 0.0);
    }

    public Map<User, Double> getUserBalanceHistory(User user) {
        if(!balanceSheet.containsKey(user)) return null;
        return balanceSheet.get(user);
    }

    public Map<User, Map<User, Double>> getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(Map<User, Map<User, Double>> balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}
