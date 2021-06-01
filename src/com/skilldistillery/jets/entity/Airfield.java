package com.skilldistillery.jets.entity;

import java.util.ArrayList;
import java.util.List;

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
	
	

}
