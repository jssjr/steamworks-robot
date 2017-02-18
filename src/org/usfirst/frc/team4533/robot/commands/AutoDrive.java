package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4533.robot.utils.SensorData;
import org.usfirst.frc.team4533.robot.utils.SensorUtilities;
import org.usfirst.frc.team4533.robot.utils.Sensors;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	private SensorData data;
	private DriveSystem drive;
	
	public AutoDrive()  {
	}

	@Override
	protected void end() {
		this.drive.stop();
	}
	@Override
	protected void execute() {
	
	}
	@Override
	protected void interrupted() {

	}

	@Override
	protected boolean isFinished() {
		return (Sensors.rearDistance > 150);
	}
	public Command drive() {
		double spd = RobotMap.DEFAULT_SPEED;
		double turnSpeed = RobotMap.DEFAULT_SPEED / 2;

		this.drive = DriveSystem.getInstance();
		this.requires(this.drive);
		
		if (Sensors.vision == "right") {
			this.drive.drive(spd, turnSpeed);
		} else if (Sensors.vision == "left") {
				this.drive.drive(turnSpeed, spd);
		} else {
			this.drive.drive(spd, spd);
		}
		
		if(Sensors.rearDistance > 150){
			this.drive.drive(spd, spd);
		} else {
			this.drive.drive(0, 0);
		}
		return this;
	}
}
