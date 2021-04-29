package com.amazon.core.lambda.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.amazon.core.dto.Dish;

public class Partitioning {
	public static void main(String... args) {
		System.out.println("Dishes partitioned by vegetarian: " + partitionByVegeterian());
		System.out.println("Vegetarian Dishes by type: " + vegetarianDishesByType());
		System.out.println("Most caloric dishes by vegetarian: " + mostCaloricPartitionedByVegetarian());
	}

	private static Object mostCaloricPartitionedByVegetarian() {
        return Dish.menu.stream().collect(
                Collectors.partitioningBy(Dish::isVegetarian,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));
    }
	private static Map<Boolean, List<Dish>> partitionByVegeterian() {
		return Dish.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
	}
	
	private static Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType() {
		return Dish.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
	}
}
