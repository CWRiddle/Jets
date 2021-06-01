package com.skilldistillery.jets.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airfield {
	
	private List<Jet> jetsInAirfield= new ArrayList<>();
	
	
	//Constructor
	public Airfield(List<Jet> jetsInAirfield) {
		this.jetsInAirfield = jetsInAirfield;
	}
	
	public static int returnNumJets(Airfield airfield) {
		return airfield.getJetsInAirfield().size();
	}

	//Getters and Setters
	public List<Jet> getJetsInAirfield() {
		return jetsInAirfield;
	}

	public void setJetsInAirfield(List<Jet> jetsInAirfield) {
		this.jetsInAirfield = jetsInAirfield;
	}
	
	public Jet getJet(int index) {
		return jetsInAirfield.get(index);	
	}
	
	public void addJet(Jet jet) {
		jetsInAirfield.add(jet);
	}
	
	/////////////////////////////////////
	//Menu Methods
	
	//Prints all jets stored in fleet
	public void listFleet() {
		for(int i=0; i<jetsInAirfield.size(); i++) {
			System.out.println(jetsInAirfield.get(i).toString());
		}
	}
	
	//Prints all jet info as well as travel time
	public void flyAllJets() {
		for(int i=0; i<jetsInAirfield.size(); i++) {
			jetsInAirfield.get(i).fly();
		}
	}
	
	//Prints out fastest jet
	public void viewFastestJet() {
		Jet highestJet = jetsInAirfield.get(0);
		for(Jet jet : jetsInAirfield) {
			if(jet.getSpeed() > highestJet.getSpeed()) {
				highestJet = jet;
			}
		}
		System.out.println(highestJet.toString());
	}
	
	//Prints out jet with longest range
	public void viewLongestRange() {
		Jet longestJet = jetsInAirfield.get(0);
		for(Jet jet : jetsInAirfield) {
			if(jet.getRange() > longestJet.getRange())
			{
				longestJet = jet;
			}
		}
		System.out.println("\nJet With Longest Range:");
		System.out.println("------------------------");
		System.out.println(longestJet.toString());
	}
	
	public void loadAllCargoJets() {
		for(Jet jet : jetsInAirfield) {
			if(jet instanceof CargoCarrier) {
				((CargoCarrier)jet).loadCargo();
				((CargoCarrier) jet).loadPassengers();
			}
		}
		
	}
	public void executeExperimentalFunctions() {
		
		for(Jet jet : jetsInAirfield) {
			if(jet instanceof ExperimentalFunction) {
				((ExperimentalFunction) jet).executeExperimentalFunction();
			}
		}
		
	}
	public void addJetToFleet(Scanner kb) {

		System.out.println("Enter name of jet: ");
		kb.nextLine();
		String name = kb.nextLine();
		System.out.println("Enter speed (in MPH): ");
		int speed = kb.nextInt();
		System.out.println("Enter range: ");
		double range = kb.nextDouble();
		System.out.println("Enter price: ");
		double price = kb.nextDouble();
		System.out.println("What type of aircraft is this: ");
		System.out.println("1. Military Aircraft");
		System.out.println("2. Civilian Aircraft");
		System.out.println("3. Experimental Aircraft");
		int aircraftType = kb.nextInt();
		
		if(aircraftType == 1)
			jetsInAirfield.add( new MilitaryAircraft(name, speed, range, price));
		if(aircraftType == 2)
			jetsInAirfield.add( new CivilianAircraft(name, speed, range, price));
		if(aircraftType == 3)
			jetsInAirfield.add( new ExperimentalAircraft(name, speed, range, price));

	}
	public void removeJetFromFleet(Scanner kb) {
		kb.nextLine();
		//Either type in name or jetID of jet to be removed
		System.out.println("Enter name of jet or the jet ID of the jet to be removed: ");
		String input = kb.nextLine();
		for(int i=0; i<jetsInAirfield.size(); i++) {
			if(input.equals(jetsInAirfield.get(i).getModel()) || input.equals(Integer.toString(jetsInAirfield.get(i).getId()))) {
				jetsInAirfield.remove(i);
			}
		}
	}
}
