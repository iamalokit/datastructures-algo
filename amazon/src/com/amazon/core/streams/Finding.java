package com.amazon.core.streams;

import java.util.Optional;

import com.amazon.core.lambda.Dish;

public class Finding {
	public static void main(String[] args) {
		if(isVegetarianFriendlyMenu()){
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
	}

	private static boolean isHealthyMenu2() {
		return Dish.menu.stream().noneMatch(d -> d.getCalories() >= 1000);
	}

	private static Optional<Dish> findVegetarianDish() {
		return Dish.menu.stream().filter(Dish:: isVegetarian).findAny();
	}

	private static boolean isHealthyMenu() {
		return Dish.menu.stream().allMatch(d -> d.getCalories() < 1000);
	}

	private static boolean isVegetarianFriendlyMenu() {
		return Dish.menu.stream().anyMatch(Dish:: isVegetarian);
	}
}
