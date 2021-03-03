package com.modernjava.chapter05;

import lombok.Getter;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class TradersTransactions {
    //Find all transactions in the year 2011 and sort them by value (small to high).
    static void test1(List<Transaction> transactions) {
        transactions
                .stream()
                .filter((Transaction transaction) -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

    }

    // What are all the unique cities where the traders work?
    static void test2(List<Transaction> transactions) {
        transactions
                .stream()
                .map((a) -> a.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        Set<String> cities =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .collect(toSet());
        System.out.println(cities);

    }

    //Find all traders from Cambridge and sort them by name.
    static void test3(List<Transaction> transactions) {
        transactions
                .stream()
                .map(Transaction::getTrader)
                .filter((Trader t) -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    //Return a string of all traders’ names sorted alphabetically
    static void test4(List<Transaction> transactions) {
        transactions
                .stream()
                .map((transaction -> transaction.getTrader().getName()))
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    //Are any traders based in Milan?
    static void test5(List<Transaction> transactions) {
        boolean isBasedInMilan = transactions
                .stream()
                .anyMatch((transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan")));
        if (isBasedInMilan) System.out.println("yes");
        else System.out.println("no");
        Optional<Transaction> tr = transactions
                .stream()
                .filter((transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan")))
                .findAny();
        tr.ifPresent(System.out::println);
    }

    //What’s the highest value of all the transactions?
    static void test6(List<Transaction> transactions) {
        Optional<Integer> max = transactions
                .stream()
                .map((Transaction::getValue))
                .reduce(Integer::max);
        max.ifPresent(System.out::println);
    }

    static void test7(List<Transaction> transactions) {
        Optional<Integer> min = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        min.ifPresent(System.out::println);
    }

    static void test8(List<Transaction> transactions) {
        Optional<Integer> sum = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        sum.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        test1(transactions);
        test2(transactions);
        test3(transactions);
        test4(transactions);
        test5(transactions);
        test6(transactions);
        test7(transactions);
        test8(transactions);
    }

    @Getter
    static class Trader {
        private final String name;
        private final String city;

        public Trader(String n, String c) {
            this.name = n;
            this.city = c;
        }

        public String toString() {
            return "Trader:" + this.name + " in " + this.city;
        }
    }

    @Getter
    static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public String toString() {
            return "{" + this.trader + ", " +
                    "year: " + this.year + ", " +
                    "value:" + this.value + "}";
        }
    }
}
