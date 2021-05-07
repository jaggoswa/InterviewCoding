package com.oops.interfaces;

public class Eagle implements Animal,Bird {
	
	public void eat() {
		System.out.println("Eats reptiles and amphibians");
	}
	
	public void sound() {
		System.out.println("Has high pitch wistling sound");
	}
	
	public void fly() {
		System.out.println("Flies upto 10,000 feet.");
	}
}
