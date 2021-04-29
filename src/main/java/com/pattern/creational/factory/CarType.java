package com.pattern.creational.factory;

import java.util.function.Supplier;

/**
 * Enumeration for different types of cars.
 */
public enum CarType {

	FORD(Ford::new), FERRARI(Ferrari::new);

	private Supplier<Car> constructor;

	CarType(Supplier<Car> instantiator) {
		this.constructor = instantiator;
	}
	
	public Car getCar() {
		return constructor.get();
	}

	
}
