package com.pattern.creational.singleton;

public class SingletonI {
	private SingletonI() 
	  {
	    // private constructor
	  }
	  
	  // Inner class to provide instance of class
	  private static class SingletonInner
	  {
	    private static final SingletonI INSTANCE = new SingletonI();
	  }
	  
	  public static SingletonI getInstance() 
	  {
	    return SingletonInner.INSTANCE;
	  }
}
