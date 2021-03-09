package com.modernjava.chapter06;

import lombok.Getter;
import java.util.stream.Collectors.*;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class GroupingTransactions {
    public enum Currency {
        EUR, USD, JPY, GBP, CHF
    }

    @Getter
    public static class Transaction {
        private final double value;
        private final Currency currency;

        public Transaction(Currency currency, double value) {
            this.value = value;
            this.currency = currency;
        }

        @Override
        public String toString() {
            return currency + " " + value;
        }
    }

    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0)
    );

    static void imperativeGrouping() {
        Map<Currency, List<Transaction>> transactionsByCurrency = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactions = transactionsByCurrency.get(currency);

            if (transactions == null) transactions = new ArrayList<>();
            transactions.add(transaction);
            transactionsByCurrency.put(currency, transactions);
        }
        System.out.println(transactionsByCurrency);
    }

    static void functionalGrouping() {
        Map<Currency, List<Transaction>> transactionsByCurrency =
                transactions.stream().collect(groupingBy(Transaction::getCurrency));
        System.out.println(transactionsByCurrency);

    }

    public static void main(String[] args) {
        imperativeGrouping();
        System.out.println("=========================");
        functionalGrouping();
    }
}
