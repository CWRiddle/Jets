package com.skilldistillery.jets.entity;

public class Cessna172Skyhawk extends CivilianAircraft {
	
	public Cessna172Skyhawk(){
		super("Cessna 172 Skyhawk", 583, 3452.338, 90000000.00);
	}
	
	public Cessna172Skyhawk(String name, int speed, double range, double price) {
		super(name, speed, range, price);
	}
	
	@Override
	public void loadCargo() {
		System.out.println("Loaded [blank] pounds of cargo into the Cessna 172 Skyhawk.");
	}

	@Override
	public void loadPassengers() {
		System.out.println("Loaded [blank] passengers in the Cessna 172 Skyhawk.");
	}
	
}
