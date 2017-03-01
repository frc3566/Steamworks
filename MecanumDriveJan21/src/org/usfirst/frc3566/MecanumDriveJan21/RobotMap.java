// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3566.MecanumDriveJan21;

import org.usfirst.frc3566l.MecanumDriveJan21.navigation.VisionValues;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    /************************************************************************
     ************************************************************************
     *
     * Set robot edition HERE before pushing code (probably only either 1 or
     * 2...)
     *
     ************************************************************************
     ***********************************************************************/
    public static final int ROBOT_EDITION = 1;

    /**
     * Test mode LiveWindow groupings
     */
    public static final String DRIVETRAIN = "Mecanum Drivetrain", BALL_ELEVATOR = "Ball Elevator", SHOOTER = "Shooter",
	    GEAR_HANDLER = "Gear Handler", CLIMBER = "Climber";

    public static CANTalon frontLeft, rearLeft, frontRight, rearRight, gearHandler, ballElevator, shooter, climber;
    public static Servo ballTrigger;
    public static Encoder driveTrainEncoder, shooterEncoder, gearHandlerEncoder;
    public static AnalogPotentiometer gearHandlerPotentiometer;
    public static DigitalInput gearLimitSwitchFront, gearLimitSwitchBack;
    public static RobotDrive mecanumDriveTrainRobotDrive;

    public static void init() {
	VisionValues.init(ROBOT_EDITION);

	switch (ROBOT_EDITION) {
	    case 1:
		frontLeft = new CANTalon(5);
		LiveWindow.addActuator(DRIVETRAIN, "Front Left (CAN 5)", frontLeft);
		frontLeft.setInverted(false);

		rearLeft = new CANTalon(6);
		LiveWindow.addActuator(DRIVETRAIN, "Rear Left (CAN 6)", rearLeft);
		rearLeft.setInverted(false);

		frontRight = new CANTalon(7);
		LiveWindow.addActuator(DRIVETRAIN, "Front Right (CAN 7)", frontRight);
		frontRight.setInverted(true);

		rearRight = new CANTalon(2);
		LiveWindow.addActuator(DRIVETRAIN, "Rear Right (CAN 2)", rearRight);
		rearRight.setInverted(true);

		driveTrainEncoder = new Encoder(4, 5);
		LiveWindow.addSensor(DRIVETRAIN, "Encoder (4, 5)", driveTrainEncoder);

		shooter = new CANTalon(1);
		LiveWindow.addActuator(SHOOTER, "Shooter (CAN 1)", shooter);

		shooterEncoder = new Encoder(2, 3);
		LiveWindow.addSensor(SHOOTER, "CIMcoder (2, 3)", shooterEncoder);

		ballTrigger = new Servo(0);
		LiveWindow.addActuator(SHOOTER, "Trigger (Servo 0)", ballTrigger);

		gearHandler = new CANTalon(3);
		LiveWindow.addActuator(GEAR_HANDLER, "Gear Handler (CAN 3)", gearHandler);

		gearLimitSwitchFront = new DigitalInput(0);
		LiveWindow.addSensor(GEAR_HANDLER, "Front Limit (0)", gearLimitSwitchFront);

		gearLimitSwitchBack = new DigitalInput(1);
		LiveWindow.addSensor(GEAR_HANDLER, "Back Limit (1)", gearLimitSwitchBack);

		gearHandlerPotentiometer = new AnalogPotentiometer(0, 360, 0);
		LiveWindow.addSensor(GEAR_HANDLER, "Potentiometer", gearHandlerPotentiometer);

		gearHandlerEncoder = new Encoder(6, 7);
		LiveWindow.addSensor(GEAR_HANDLER, "Encoder (6, 7)", gearHandlerEncoder);

		/**
		 * encoder1 = new Encoder(0, 1); //parameters: A channel and B
		 * channel encoder1.setMaxPeriod(.1); encoder1.setMinRate(10);
		 * encoder1.setDistancePerPulse(5);
		 * encoder1.setReverseDirection(true);
		 * encoder1.setSamplesToAverage(7);
		 **/

		ballElevator = new CANTalon(8);
		LiveWindow.addActuator(BALL_ELEVATOR, "Ball Elevator (CAN 8)", ballElevator);

		climber = new CANTalon(9);
		LiveWindow.addActuator(CLIMBER, "Climber (CAN 9)", climber);

		break;

	    case 2:
	    default:
		frontLeft = new CANTalon(5);
		LiveWindow.addActuator(DRIVETRAIN, "Front Left (CAN 5)", frontLeft);
		frontLeft.setInverted(true);

		rearLeft = new CANTalon(9);
		LiveWindow.addActuator(DRIVETRAIN, "Rear Left (CAN 9)", rearLeft);
		rearLeft.setInverted(true);

		frontRight = new CANTalon(3);
		LiveWindow.addActuator(DRIVETRAIN, "Front Right (CAN 3)", frontRight);
		frontRight.setInverted(false);

		rearRight = new CANTalon(2);
		LiveWindow.addActuator(DRIVETRAIN, "Rear Right (CAN 2)", rearRight);
		rearRight.setInverted(false);

		driveTrainEncoder = new Encoder(4, 5);
		LiveWindow.addSensor(DRIVETRAIN, "Encoder (4, 5)", driveTrainEncoder);

		shooter = new CANTalon(4);
		LiveWindow.addActuator(SHOOTER, "Shooter (CAN 4)", shooter);

		shooterEncoder = new Encoder(2, 3);
		LiveWindow.addSensor(SHOOTER, "CIMcoder (2, 3)", shooterEncoder);

		ballTrigger = new Servo(0);
		LiveWindow.addActuator(SHOOTER, "Trigger (Servo 0)", ballTrigger);

		gearHandler = new CANTalon(1);
		LiveWindow.addActuator(GEAR_HANDLER, "Gear Handler (CAN 1)", gearHandler);

		gearLimitSwitchFront = new DigitalInput(0);
		LiveWindow.addSensor(GEAR_HANDLER, "Front Limit (0)", gearLimitSwitchFront);

		gearLimitSwitchBack = new DigitalInput(1);
		LiveWindow.addSensor(GEAR_HANDLER, "Back Limit (1)", gearLimitSwitchBack);

		gearHandlerPotentiometer = new AnalogPotentiometer(0, 360, 0);
		LiveWindow.addSensor(GEAR_HANDLER, "Potentiometer", gearHandlerPotentiometer);

		gearHandlerEncoder = new Encoder(6, 7);
		LiveWindow.addSensor(GEAR_HANDLER, "Encoder (6, 7)", gearHandlerEncoder);

		ballElevator = new CANTalon(7);
		LiveWindow.addActuator(BALL_ELEVATOR, "Ball Elevator (CAN 7)", ballElevator);

		climber = new CANTalon(6);
		LiveWindow.addActuator(CLIMBER, "Climber (CAN 6)", climber);

		break;
	}

	mecanumDriveTrainRobotDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	mecanumDriveTrainRobotDrive.setSafetyEnabled(true);
	mecanumDriveTrainRobotDrive.setExpiration(0.1);
	mecanumDriveTrainRobotDrive.setSensitivity(0.5);
	mecanumDriveTrainRobotDrive.setMaxOutput(1.0);

    }
}
