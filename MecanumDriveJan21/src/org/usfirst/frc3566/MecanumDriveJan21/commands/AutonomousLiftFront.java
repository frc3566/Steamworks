// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3566.MecanumDriveJan21.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc3566.MecanumDriveJan21.FishyCam;
import org.usfirst.frc3566.MecanumDriveJan21.Robot;
import org.usfirst.frc3566.MecanumDriveJan21.VisionValues;

/**
 *
 */
public class AutonomousLiftFront extends Command {
	private boolean finished;
	//this is the autonomous command for when there is a lift in front of the robot
	public AutonomousLiftFront(){
		
	}

    public boolean checkArea(){
   //checks if the avgArea of the detected targets meets the target area requirements of the Lift 
    	if(FishyCam.getArea() > VisionValues.idealVerticalTargetArea){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    protected void initialize() {
    	finished = false;
    }

    protected void execute() {
    	//delay is 0 in the method below because this is called in the execute loop. 
    	//Since the motor is already receiving constant commands, no extra delay is needed
    	
    	if(checkArea()){
    		Robot.mecanumDriveTrain.stopDriveTrain();
    		Timer.delay(1);
        	new moveGearDeliveryPositive(0.5, 0.8, new DriveForDistance('b', 1, 0.2)).start();
        	finished = true;
    	}else{
    		Robot.mecanumDriveTrain.driveTrainForward(0.15);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//when detected target area is big enough, calls the command to stop
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.mecanumDriveTrain.stopDriveTrain();
    }
}
