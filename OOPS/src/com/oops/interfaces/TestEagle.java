package com.oops.interfaces;

public class TestEagle {

	public static void main(String[] args) {
		Eagle myEagle = new Eagle();
		
		myEagle.eat();
		myEagle.sound();
		myEagle.fly();
		
		System.out.println("Number of legs: " + Bird.numberOfLegs);
		System.out.println("Outer Covering: " + Bird.outerCovering);

	}

}
