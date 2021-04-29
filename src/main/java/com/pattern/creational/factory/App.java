package com.pattern.creational.factory;


/**
 * Factory is an object for creating other objects, it providing Providing a static method to 
 * create and return objects of varying classes, in order to hide the implementation logic 
 * and makes client code focus on usage rather then objects initialization and management.
 *
 * <p>In this example the CarFactory is the factory class and it provides a static method to 
 * create different cars.
 */

public class App {

  /**
   * Program main entry point.
   */
  public static void main(String[] args) {
    Car car1 = CarsFactory.getCar(CarType.FORD);
    Car car2 = CarsFactory.getCar(CarType.FERRARI);
    System.out.println(car1.getDescription());
    System.out.println(car2.getDescription());
  }
}
