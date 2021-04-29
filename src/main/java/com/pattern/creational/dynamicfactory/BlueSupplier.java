package com.pattern.creational.dynamicfactory;

import java.util.function.Supplier;

public class BlueSupplier implements Supplier<Tier> {

	@Override
	public Tier get() {
		 return new Blue();
	}

}
