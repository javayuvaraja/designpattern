package com.pattern.creational.builder;

public class BuilderTest {
	public static void main(String[] args) {
	    User user1 = new User.UserBuilder("Yuva", "Raja")
	    .age(38)
	    .phone("72822")
	    .address("Address 1234")
	    .build();
	 
	    System.out.println(user1);
	 
	    User user2 = new User.UserBuilder("Krish", "Raja")
	    .age(40)
	    .phone("5252255")
	    //no address
	    .build();
	 
	    System.out.println(user2);
	 
	    User user3 = new User.UserBuilder("Udi", "Raja")
	    //No age
	    //No phone
	    //no address
	    .build();
	 
	    System.out.println(user3);
	}
	
}
