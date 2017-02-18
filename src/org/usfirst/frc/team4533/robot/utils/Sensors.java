package org.usfirst.frc.team4533.robot.utils;

public class Sensors {

	// Sensor readings
	public static double heading;
	public static double rearDistance;
	public static String vision;
	
	// Protocol delimiters
	private static final byte syncByte = 94;
	private static final byte endSec = 126;
	
	public Sensors() {
		// We should probably set some things up here...
	}
	
	public void fetchData() {
		// Read information from the arduino serial if we can, then update the sensor values we're tracking
	}
}
