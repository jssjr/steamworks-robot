package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command{
	public ClimbCommand() {
		requires(Robot.climber);
	}
	
	
	
	@Override
	protected void execute() {
		System.out.println("here");
		Robot.climber.climb();
		
	}
	
	@Override
	protected void end() {
		Robot.climber.brake();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	

}
