package com.skilldistillery.jets.entity;

public class McDonnelDouglasFA18Hornet extends MilitaryAircraft{
	
	public McDonnelDouglasFA18Hornet()
	{
		super("McDonnell Douglas F/A-18 Hornet", 1190, 500, 40000000.00);
	}
	
	public McDonnelDouglasFA18Hornet(String name, int speed, double range, double price) {
		super(name, speed, range, price);
	}

}
