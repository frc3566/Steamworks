package org.usfirst.frc3566.MecanumDriveJan21.commands;

import org.usfirst.frc3566.MecanumDriveJan21.Robot;
import org.usfirst.frc3566.MecanumDriveJan21.VisionValues;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseGearHandler extends Command {

	Command endCommand; 
	double mySpeed;
	double distance = -1;
	boolean finished = false;
	
    public RaiseGearHandler() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	mySpeed=0.7;
    }
    
    public RaiseGearHandler(double speed, double PotentiometerDistance){
    	mySpeed = speed;
    	distance = PotentiometerDistance;
    	this.setTimeout(5);
    }

    public RaiseGearHandler(double Timeout, double speed, Command end){
    	this.setTimeout(Timeout);
    	endCommand = end;
    	mySpeed = speed;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(distance != -1){
    		if(Math.abs(Robot.gearPotentiometer.get()-VisionValues.potentiometer0 - distance)> 2){
    			Robot.gearDelivery.deliver(mySpeed);
    		}else{
    			finished = true;
    		}
    	}else{
    	Robot.gearDelivery.deliver(mySpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       // return (!Robot.gearLimitSwitchFront.get());
    	return (finished || this.isTimedOut() || (!Robot.gearLimitSwitchFront.get()));
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(endCommand!=null){
    		endCommand.start();
    	}
    	Robot.gearDelivery.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}