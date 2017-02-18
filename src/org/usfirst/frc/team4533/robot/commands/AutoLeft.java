package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.utils.SensorData;
import org.usfirst.frc.team4533.robot.utils.SensorUtilities;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLeft extends Command {

	private static double DEFAULT_DRIVE_SPEED;

	public AutoLeft(double speed) {
		requires(Robot.drive);
		DEFAULT_DRIVE_SPEED = speed;
	}

	@Override
	protected void end() {
		Robot.drive.stop();
	}

	@Override
	protected void execute() {
		Robot.drive.turnLeft(-DEFAULT_DRIVE_SPEED, DEFAULT_DRIVE_SPEED);
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected boolean isFinished() {
		SensorData data = SensorUtilities.interpretSerial();
		if (data.getName() == "PIXY" && data.getUnit() == "direction") {
			return data.getValue().equals("left");
		}
		return false;
	}
}