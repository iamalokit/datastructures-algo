package com.amazon.core.optional;

import java.util.Optional;


public class OptionalMain {
	public String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
	}
	
	// jdk 9
//	public Set<String> getCarInsuranceNames(List<Person> persons) {
//		return persons.stream().map(Person::getCar).map(optCar -> optCar.flatMap(Car::getInsurance))
//				.map(optInsurance -> optInsurance.map(Insurance::getName)).flatMap(Optional::stream).collect(Collectors.toSet());
//	}

}
