package com.oops.compiletimepolymorphism;

public class TestBird {

	public static void main(String[] args) {
		Bird myBird = new Bird();
		
		myBird.fly();
		myBird.fly(1000);
		myBird.fly("Eagle",1000);

	}

}
