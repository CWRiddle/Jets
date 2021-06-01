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
		menu(airfield);
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
	private void menu(Airfield airfield) {
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
					airfield.listFleet();
					break;
				case 2:
					airfield.flyAllJets();
					break;
				case 3:
					airfield.viewFastestJet();
					break;
				case 4:
					airfield.viewLongestRange();
					break;
				case 5:
					airfield.loadAllCargoJets();
					break;
				case 6:
					airfield.executeExperimentalFunctions();
					break;
				case 7:
					airfield.addJetToFleet(kb);
					break;
				case 8:
					airfield.removeJetFromFleet(kb);
					break;
				case 9:
					System.out.println("Program Ended.");
					looping = false;
					break;
			}
		}
		kb.close();
	}
}
