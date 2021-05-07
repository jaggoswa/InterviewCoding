package com.oops.inheritance;

public class TestEagle {

	public static void main(String[] args) {
		Eagle myEagle = new Eagle();
		
		System.out.println("Name: " + myEagle.name);
		System.out.println("Lifespan: " + myEagle.lifespan);
		System.out.println("Number of legs: " + myEagle.numberOfLegs);
		System.out.println("Outer Covering: " + myEagle.outerCovering);
		
		myEagle.flyUp();
		myEagle.flyDown();

	}

}
