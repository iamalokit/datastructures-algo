package com.amazon.core.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.amazon.core.streams.dto.Trader;
import com.amazon.core.streams.dto.Transaction;

public class PuttingIntoPractice {
	public static void main(String... args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Query 1: Find all transactions from year 2011 and sort them by value (small
		// to high).
		List<Transaction> sortedTransactions = transactions.stream().filter(t -> t.getYear() == 2011).sorted()
				.collect(Collectors.toList());

		System.out.println(sortedTransactions);

		// Query 2: What are all the unique cities where the traders work?
		List<String> cities = transactions.stream().map(t -> t.getTrader().getCity()).distinct()
				.collect(Collectors.toList());
		System.out.println(cities);

		// Query 3: Find all traders from Cambridge and sort them by name.
		transactions.stream().map(t -> t.getTrader()).filter(trader -> "Cambridge".equals(trader.getCity()))
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());

		// Query 4: Return a string of all traders’ names sorted alphabetically.
		String tradeStr = transactions.stream().map(tr -> tr.getTrader().getName()).distinct().sorted().reduce("",
				(n1, n2) -> n1 + n2);
		System.out.println(tradeStr);

		// Query 5: Are there any trader based in Milan?
		boolean milanBased = transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		
		System.out.println(milanBased);
		
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
		transactions.stream().map(tr -> tr.getTrader()).filter(t -> "Milan".equals(t.getCity())).forEach(t -> t.setCity("Cambridge"));
		System.out.print(transactions);
		
        // Query 7: What's the highest value in all the transactions?
		int highestValue = transactions.stream().map(tr -> tr.getValue()).reduce(0, Integer::max);
		System.out.println(highestValue);



	}
}
