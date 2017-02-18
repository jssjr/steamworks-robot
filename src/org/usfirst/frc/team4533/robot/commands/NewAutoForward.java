package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.utils.SensorData;
import org.usfirst.frc.team4533.robot.utils.SensorUtilities;

import edu.wpi.first.wpilibj.command.Command;

public class NewAutoForward extends Command {

	private static double DEFAULT_DRIVE_SPEED;

	public NewAutoForward(double speed) {
		requires(Robot.drive);
		DEFAULT_DRIVE_SPEED = speed;
	}

	@Override
	protected void end() {
		Robot.drive.stop();
	}

	@Override
	protected void execute() {
		Robot.drive.forward(DEFAULT_DRIVE_SPEED);
	}

	@Override
	protected void interrupted() {

	}

	@Override
	protected boolean isFinished() {
		boolean finished = false;
		SensorData data = SensorUtilities.interpretSerial();

		
		if (data.getName() == "LIDAR" && data.getUnit() == "cm") {
			int distance = Integer.parseInt(data.getValue());
			int target = RobotMap.LIDAR_DISTANCE_IN + 10;
			finished = (distance > target);
		}
		
		return finished;
	}
}
