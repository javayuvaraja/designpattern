package com.pattern.creational.dynamicfactory;

import java.util.function.Supplier;

public class GoldenSupplier  implements Supplier<Tier> {

	@Override
	public Tier get() {
		 return new Gold();
	}
}

