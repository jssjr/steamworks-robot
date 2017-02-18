package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
//Imports the command class from the first api

public class DriveForward extends Command{ //This new command allows the robot to move forward
	private final double speed;//Same concept but for speed that is in a -1 to 1 range and can not be changed in this class
	
	public DriveForward(double speed) { //Reuses the DriveForward command in DriveSystem
		this.speed = speed; //Creates a variable speed that is equal to speed
		requires(Robot.drive);
	}
	
	protected void execute() { //Executing drive.forward
		Robot.drive.forward(this.speed);
	}
	
	protected void end() { //Ends driving forward
		Robot.drive.stop();
	}
	
	protected void interrupted() { //If interrupted the robot will stop
		Robot.drive.stop();
	}
	
	@Override
	protected void initialize() { //Initialize
		
	}
	
	@Override
	protected boolean isFinished() { //When the timer reaches 0 the boolean returns false and we can't drive forward
		return false;
	}
}
