package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.utils.SensorData;
import org.usfirst.frc.team4533.robot.utils.SensorUtilities;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	private SensorData data;
	
	public AutoDrive()  {
		requires(Robot.drive);
	}

	@Override
	protected void end() {
		Robot.drive.stop();
	}
	@Override
	protected void execute() {
	
	}
	@Override
	protected void interrupted() {

	}

	@Override
	protected boolean isFinished() {
		int distance = 0;
		if (data.getName().equals("LIDAR") && data.getUnit().equals("cm")) {
			distance = Integer.parseInt(data.getValue());
		}
		
		return (distance > 150);
	}
	public Command drive() {
		double spd = RobotMap.DEFAULT_SPEED;
		double turnSpeed = RobotMap.DEFAULT_SPEED / 2;
		data = SensorUtilities.interpretSerial();
		if (data.getName() == "PIXY" && data.getUnit() == "direction") {
			if (data.getValue() == "right") {
				Robot.drive.drive(spd, turnSpeed);
			} else if (data.getValue() == "left") {
				Robot.drive.drive(turnSpeed, spd);
			} else {
				Robot.drive.drive(spd, spd);
			}
		} else if(data.getName().equals("LIDAR") && data.getUnit().equals("cm")){
			while(Integer.parseInt(data.getValue()) < 150){
				Robot.drive.drive(spd, spd);
			}
			Robot.drive.drive(0, 0);;			
		}else{
			System.out.println("ERROR: incorrect data format");
			System.out.println("NAME: " + data.getName() + "||UNIT: " + data.getUnit() + "||VALUE: " + data.getValue());
		}
		return this;
	}
}
