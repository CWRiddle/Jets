package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entity.*;




public class JetApplication {
	
	public static void main(String[] args) {
		
		JetApplication jetApp = new JetApplication();
		jetApp.runApp();
		
	}
	
	private void runApp() {
		//Designate file to read from
		File file = new File("Aircraft.txt");
		
		//Creates list of jets
		List<Jet> jets = new ArrayList<>();
		
		//Reads file and sorts contents into Jet objects
		readFile(file, jets);
		
		//Stores jets into airfield
		Airfield airfield = new Airfield(jets);
		
		//Presents Menu
		menu(jets);
	}
	
	private void readFile(File file, List<Jet> jets) {
		
		try ( BufferedReader br = new BufferedReader( new FileReader(file)) ){
			String line;
			while((line = br.readLine()) != null) {
				jets.add( parseFileContents(line) );
			}
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		

	}
	
	//Parses the contents of lines read from files into the correct Jet object
	private Jet parseFileContents(String line) {
		
		//Splits line up into an array of strings, splitting at commas
        String[] jetData = line.split(", ");

        //Sorts String elements into appropriate
        String name = jetData[0];
        int speed = Integer.parseInt(jetData[1]);
        double range = Double.parseDouble(jetData[2]);
        double price = Double.parseDouble(jetData[3]);
        
        //Compares names read from file to the names of the objects they belong to
        if(name.equals("Northorp Grumman B-2 Spirit")) {
        	Jet jet = new NorthropGrummanB2Spirit(name, speed, range, price);
        	return jet;
        }
        else if(name.equals("Boeing 737")) {
        	Jet jet = new Boeing737(name, speed, range, price);
        	return jet;
        }
        else if(name.equals("Boeing V-22 Osprey")) {
        	Jet jet = new BoeingV22Osprey(name, speed, range, price);
        	return jet;
        }
        else if(name.equals("Caspian Sea Monster")) {
        	Jet jet = new CaspianSeaMonster(name, speed, range, price);
        	return jet;
        }
        else if(name.equals("Cessna 172 Skyhawk")) {
        	Jet jet = new Cessna172Skyhawk(name, speed, range, price);
        	return jet;
        }
        else if(name.equals("McDonnell Douglas FA-18 Hornet")) {
        	Jet jet = new McDonnelDouglasFA18Hornet(name, speed, range, price);
        	return jet;
        }
        else if(name.equals("Flux Liner")) {
        	Jet jet = new FluxLiner(name, speed, range, price);
        	return jet;
        }
        else	//returns null if none of the file contents match pre-declared objects
        	return null;
	}
	
	//Displays menu
	private void menu(List<Jet> jets) {
		int input;
		boolean looping = true;
		Scanner kb = new Scanner(System.in);
		
		while(looping) {
			System.out.println("+-----------------------------------+");
			System.out.println("|               MENU:               |");
			System.out.println("+-----------------------------------+");
			System.out.println("| 1) List Fleet                     |");
			System.out.println("| 2) Fly All Jets                   |");
			System.out.println("| 3) View Fastest Jet               |");
			System.out.println("| 4) View Jet with Longest Range    |");
			System.out.println("| 5) Load all Cargo Jets            |");
			System.out.println("| 6) Execute Experimental Function  |");
			System.out.println("| 7) Add a jet to Fleet             |");
			System.out.println("| 8) Remove a jet from Fleet        |");
			System.out.println("| 9) Quit                           |");
			System.out.println("+-----------------------------------+");
			
			System.out.print("|-> Select an option on the menu: ");
			input = kb.nextInt();
			
			//Calls relevant method for menu selection
			switch(input) {
				case 1:
					listFleet(jets);
					break;
				case 2:
					flyAllJets(jets);
					break;
				case 3:
					viewFastestJet(jets);
					break;
				case 4:
					viewLongestRange(jets);
					break;
				case 5:
					loadAllCargoJets(jets);
					break;
				case 6:
					executeExperimentalFunctions(jets);
					break;
				case 7:
					addJetToFleet(jets, kb);
					break;
				case 8:
					removeJetFromFleet(jets, kb);
					break;
				case 9:
					System.out.println("Program Ended.");
					looping = false;
					break;
			}
		}
		kb.close();
	}
	
	//Prints all jets stored in fleet
	public void listFleet(List<Jet> jets) {
		for(int i=0; i<jets.size(); i++) {
			System.out.println(jets.get(i).toString());
		}
	}
	
	//Prints all jet info as well as travel time
	public void flyAllJets(List<Jet> jets) {
		for(int i=0; i<jets.size(); i++) {
			jets.get(i).fly();
		}
	}
	
	//Prints out fastest jet
	public void viewFastestJet(List<Jet> jets) {
		Jet highestJet = jets.get(0);
		for(Jet jet : jets) {
			if(jet.getSpeed() > highestJet.getSpeed()) {
				highestJet = jet;
			}
		}
		System.out.println(highestJet.toString());
	}
	
	//Prints out jet with longest range
	public void viewLongestRange(List<Jet> jets) {
		Jet longestJet = jets.get(0);
		for(Jet jet : jets) {
			if(jet.getRange() > longestJet.getRange())
			{
				longestJet = jet;
			}
		}
		System.out.println("\nJet With Longest Range:");
		System.out.println("------------------------");
		System.out.println(longestJet.toString());
	}
	public void loadAllCargoJets(List<Jet> jets) {
		for(Jet jet : jets) {
			if(jet instanceof CargoCarrier) {
				((CargoCarrier)jet).loadCargo();
				((CargoCarrier) jet).loadPassengers();
			}
		}
		
	}
	public void executeExperimentalFunctions(List<Jet> jets) {
		
		for(Jet jet : jets) {
			if(jet instanceof ExperimentalFunction) {
				((ExperimentalFunction) jet).executeExperimentalFunction();
			}
		}
		
	}
	public void addJetToFleet(List<Jet> jets, Scanner kb) {

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
			jets.add( new MilitaryAircraft(name, speed, range, price));
		if(aircraftType == 2)
			jets.add( new CivilianAircraft(name, speed, range, price));
		if(aircraftType == 3)
			jets.add( new ExperimentalAircraft(name, speed, range, price));

	}
	public void removeJetFromFleet(List<Jet> jets, Scanner kb) {
		kb.nextLine();
		//Either type in name or jetID of jet to be removed
		System.out.println("Enter name of jet or the jet ID of the jet to be removed: ");
		String input = kb.nextLine();
		for(int i=0; i<jets.size(); i++) {
			if(input.equals(jets.get(i).getModel()) || input.equals(Integer.toString(jets.get(i).getId()))) {
				jets.remove(i);
			}
		}
	}

}
