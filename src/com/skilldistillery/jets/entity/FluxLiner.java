package com.skilldistillery.jets.entity;

public class FluxLiner extends ExperimentalAircraft implements ExperimentalFunction {
	
	//Default Constructor with default values
	public FluxLiner(){
		super("FluxLiner", 100000, 90000, 0.0);
	}
	
	//Constructor to be called when entering custom values
	public FluxLiner(String name, int speed, double range, double price){
		super(name, speed, range, price);
	}

	
	@Override
	public void executeExperimentalFunction() {
		goSuperLuminal();
	}
	
	private void goSuperLuminal() {
		System.out.println("One minute the Flux Liner is hovering above the ground. Suddenly, in the blink of an eye, the Flux Liner"
				+ " shoots off into the distance at a speed faster than light");
	}
}
