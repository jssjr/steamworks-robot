package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BrakeCommand extends Command{
	public BrakeCommand() {
		requires(Robot.climber);
	}
		
	@Override
	protected void execute() {
		Robot.climber.brake();
	}
	
	@Override
	protected boolean isFinished() {
		Robot.climber.brake();
		return false;
	}
	
}
