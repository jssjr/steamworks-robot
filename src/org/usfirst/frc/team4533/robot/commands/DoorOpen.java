package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DoorOpen extends Command {
		
	public DoorOpen() {
		requires(Robot.shooter);
	}
	
	@Override
	public void execute() {	
		Robot.shooter.openDoor();
	}
	
	@Override
	public void end() {
		Robot.shooter.closeDoor();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
