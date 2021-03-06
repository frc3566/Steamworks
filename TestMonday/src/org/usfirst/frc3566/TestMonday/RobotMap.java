// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3566.TestMonday;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainCANTalon0;
    public static CANTalon driveTrainCANTalon1;
    public static RobotDrive driveTrainRobotDrive01;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainCANTalon0 = new CANTalon(0);
        LiveWindow.addActuator("driveTrain", "CAN Talon 0", driveTrainCANTalon0);
        
        driveTrainCANTalon1 = new CANTalon(1);
        LiveWindow.addActuator("driveTrain", "CAN Talon 1 ", driveTrainCANTalon1);
        
        driveTrainRobotDrive01 = new RobotDrive(driveTrainCANTalon0, driveTrainCANTalon1);
        
        driveTrainRobotDrive01.setSafetyEnabled(true);
        driveTrainRobotDrive01.setExpiration(0.1);
        driveTrainRobotDrive01.setSensitivity(0.5);
        driveTrainRobotDrive01.setMaxOutput(1.0);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
