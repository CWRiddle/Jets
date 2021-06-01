package com.skilldistillery.jets.entity;

public class NorthropGrummanB2Spirit extends MilitaryAircraft implements CombatReady{
	
	public NorthropGrummanB2Spirit(){
		super("Northorp Grumman B-2 Spirit", 628, 6897.2, 2000000000.00);
	}

	public NorthropGrummanB2Spirit(String name, int speed, double range, double price){
		super(name, speed, range, price);
	}
	
	@Override
	public void loadPayload() {
		System.out.println("Payload loaded.");		
	}

	@Override
	public void fight() {
		System.out.println("Fighting.");
	}
}
