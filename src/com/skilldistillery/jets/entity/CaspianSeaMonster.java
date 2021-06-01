package com.skilldistillery.jets.entity;

public class CaspianSeaMonster extends ExperimentalAircraft implements ExperimentalFunction{

	//Default constructor with default values
	public CaspianSeaMonster(){
		super("Caspian Sea Monster", 311, 932.1, 0);
	}
	
	//Constructor for custom values
	public CaspianSeaMonster(String name, int speed, double range, double price){
		super(name, speed, range, price);
	}
	
	@Override
	public void executeExperimentalFunction() {
		flyOverWater();
	}
	
	private void flyOverWater() {
		System.out.println("The Caspian Sea Monster takes off from the water, soars just above the surface, and lands back on the water");
	}
}
