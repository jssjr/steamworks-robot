package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootCommand extends Command {
	public ShootCommand() {
		requires(Robot.shooter);
	}
		
	@Override
	public void execute(){
		Robot.shooter.startFlywheel();
	}
	
	@Override
	public void end() {
		Robot.shooter.stopFlywheel();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
