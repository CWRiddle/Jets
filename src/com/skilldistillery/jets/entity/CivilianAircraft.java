package com.skilldistillery.jets.entity;

public class CivilianAircraft extends Jet implements CargoCarrier {

	public CivilianAircraft(String name, int speed, double range, double price) {
		super(name, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println("Loaded cargo.");
	}

	@Override
	public void loadPassengers() {
		System.out.println("Loaded passengers.");
	}
	
}
