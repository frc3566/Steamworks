package org.usfirst.frc3566.MecanumDriveJan21.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDistance extends Command {

    public AutoDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	new DriveForDistance('f',3, 0.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}