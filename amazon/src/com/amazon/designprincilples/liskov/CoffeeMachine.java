package com.amazon.designprincilples.liskov;

public interface CoffeeMachine {
	CoffeeDrink brewCoffee(CoffeeSelection selection) throws CoffeeException;
}
