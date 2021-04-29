package com.amazon.core.lambda.collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazon.core.dto.Currency;
import com.amazon.core.dto.CurrencyTransaction;


public class GroupingTransactions {

	public static List<CurrencyTransaction> transactions = Arrays.asList(new CurrencyTransaction(Currency.EUR, 1500.0),
			new CurrencyTransaction(Currency.USD, 2300.0), new CurrencyTransaction(Currency.GBP, 9900.0),
			new CurrencyTransaction(Currency.EUR, 1100.0), new CurrencyTransaction(Currency.JPY, 7800.0),
			new CurrencyTransaction(Currency.CHF, 6700.0), new CurrencyTransaction(Currency.EUR, 5600.0),
			new CurrencyTransaction(Currency.USD, 4500.0), new CurrencyTransaction(Currency.CHF, 3400.0),
			new CurrencyTransaction(Currency.GBP, 3200.0), new CurrencyTransaction(Currency.USD, 4600.0),
			new CurrencyTransaction(Currency.JPY, 5700.0), new CurrencyTransaction(Currency.EUR, 6800.0));
	
	public static void main(String ... args) {
        groupImperatively();
        groupFunctionally();

    }

	private static void groupFunctionally() {
		Map<Currency, List<CurrencyTransaction>> transactionsByCurrencies = 
				transactions.stream().collect(Collectors.groupingBy(CurrencyTransaction::getCurrency));
		System.out.println(transactionsByCurrencies);
	}

	private static void groupImperatively() {
		Map<Currency, List<CurrencyTransaction>> transactionByCurrencies = new HashMap<>();
		for(CurrencyTransaction transaction: transactions) {
			Currency currency = transaction.getCurrency();
			List<CurrencyTransaction> transactionsForCurrency = transactionByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                    transactionsForCurrency = new ArrayList<>();
                    transactionByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
		}
		System.out.println(transactionByCurrencies);
	}
	
	
	

}
