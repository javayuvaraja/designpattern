package com.pattern.creational.dynamicfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DynamicSupplierTierFactory {
	private static final Map<String,Supplier<? extends Tier>> registeredSuppliers=
			new HashMap<>();
	static { 
		registeredSuppliers.put("blue", new BlueSupplier()); 
		registeredSuppliers.put("silver", new SilverSupplier()); 
		registeredSuppliers.put("golden", new GoldenSupplier());
	}

	 public static void registerSupplier(String type, 
			 Supplier<? extends Tier> supplier) {
		 registeredSuppliers.put(type, supplier);
	 }
	 
	 public static Tier getTier(String type) {
		 Supplier<? extends Tier> supplier =registeredSuppliers.get(type); 
		 return supplier!=null ? supplier.get() : null;
	 }
}
