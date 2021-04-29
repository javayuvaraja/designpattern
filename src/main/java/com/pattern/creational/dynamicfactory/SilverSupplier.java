package com.pattern.creational.dynamicfactory;

import java.util.function.Supplier;

public class SilverSupplier implements Supplier<Tier> {

	@Override
	public Tier get() {
		 return new Silver();
	}

}
