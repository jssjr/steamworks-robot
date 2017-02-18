package org.usfirst.frc.team4533.robot.utils;

import edu.wpi.first.wpilibj.SerialPort;

public class Sensors {

	// Sensor readings
	public static double heading;
	public static double rearDistance;
	public static String vision;
	
	// Protocol delimiters
	private static final byte syncByte = 94;
	private static String syncPattern;
	private static final byte sepByte = 126;
	private static String sepPattern;
	private static String previousBuffer;
	
	// Comms
	private static SerialPort arduino;
	
	public Sensors() {
		arduino = new SerialPort(115200, SerialPort.Port.kUSB);
		previousBuffer = "";
		syncPattern += (char)syncByte;
		sepPattern += (char)sepByte;
	}
	
	public static void fetchData() {		
		String buffer;
		String items[];
		String data[];
		
		// Spin until we drain the serial
		buffer = arduino.readString();
		buffer = previousBuffer + buffer;
		for (int i = 0; i < buffer.length(); i++) {
			items = buffer.split(syncPattern);
			if (items.length == 1) {
				// We didn't match anything :( put it back in the buffer
				previousBuffer = buffer;
				return;
			}
			for (int c = 0; c < items.length; c++) {
				data = items[c].split(sepPattern);
				if (data.length != 3) {
					// This isn't a complete data packet :( put it back in the buffer
					previousBuffer = String.join(sepPattern, data);
					return;
				}
				
				// Set our sensor data
				switch (data[0]) {
				case "heading":
					heading = Double.parseDouble(data[2]);
					break;
				case "lidar":
					rearDistance = Double.parseDouble(data[2]);
					break;
				case "pixy":
					vision = data[2];
					break;
				}
			}
		}
	}
}
