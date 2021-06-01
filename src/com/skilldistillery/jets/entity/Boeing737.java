package com.skilldistillery.jets.entity;

public class Boeing737 extends CivilianAircraft{
	
	public Boeing737(){
		super("Boeing 737", 583, 3452.338, 90000000.00);
	}
	
	public Boeing737(String name, int speed, double range, double price) {
		super(name, speed, range, price);
	}
	
	@Override
	public void loadCargo(){
		System.out.println("The Boeing 737 loaded [blank] pounds of cargo into its cargo hold.");
	}
	
	@Override
	public void loadPassengers(){
		System.out.println("The Boeing 737 loaded [blank] passengers on board.");
	}

}
