package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithDistanceReading extends Command {
	private final double speed;
	private double frontDistance;
	private double rearDistance;
	
	public DriveWithDistanceReading(double speed, double frontDistance, double rearDistance) {
		this.speed = -speed;
		this.frontDistance = frontDistance;
		this.rearDistance = rearDistance;
		requires(Robot.drive);
	}


	protected void execute() {
		Robot.drive.forward(this.speed);
	}


	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		Robot.drive.stop();
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected boolean isFinished() {
		if(frontDistance == -1){
			if (Robot.rearDistance > rearDistance) {
				return true;
			}
		}else{
			if (DriveSystem.ultraSonic() < frontDistance){
				return true;
			}
		}
		return false;
	}
}
