package com.skilldistillery.jets.entity;

public abstract class Jet {

	//Fields
	private String model;
	private int speed;
	private double range;
	private double price;
	private int jetId;
	
	public static int numJets = 0;
	
	Jet(String model, int speed, double range, double price){
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.jetId = numJets;
		numJets++;
	}
	
	//Methods
	public double getSpeedInMach() {
		//speed divided by speed of sound in mph
		double speedInMach = this.speed / 767.269148;	
	
		return speedInMach;
	}
	
	public void fly() {
		double flyTime = this.range / this.speed;
		double flyTimeMinutes = flyTime * 60;
		int flyTimeHours = (int)(flyTimeMinutes / 60);
		flyTimeMinutes %= 60; //60 * flyTimeInHours;
		int flyTimeSeconds = (int) (60 *(flyTimeMinutes % 60));
		
		System.out.println(toString() + "\nFly time: " + flyTimeHours + " hr : " + (int)flyTimeMinutes + " min : " + flyTimeSeconds + " s");
	}
	
	@Override
	public String toString()
	{
		return ("Jet ID: " + jetId + "\n\tModel: " + this.model + "\n\tSpeed: " + this.speed + "\n\tRange: " + this.range + "\n\tPrice: " + price);
	}
	
	//Getters and Setters
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getId() {
		return jetId;
	}
	
	
}
