package com.skilldistillery.jets.entity;

public class BoeingV22Osprey extends MilitaryAircraft {
	
	public BoeingV22Osprey(){
		super("Boeing V-22 Osprey", 583, 3452.338, 90000000.00);
	}
	
	public BoeingV22Osprey(String name, int speed, double range, double price) {
		super(name, speed, range, price);
	}

}
