package org.usfirst.frc.team2928;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2928.commands.*;

public class OperatorInterface {

    // TODO: Determine proper port for joystick/buttons
    private static final int DRIVE_JOYSTICK_PORT = 0;
    private static final int OPERATOR_STICK_PORT = 1;
    private static final int FLIP_OUT_BUTTON_PORT = 1;
    private static final int FLIP_IN_BUTTON_PORT = 2;
    private static final int OPEN_GEAR_MANIPULATOR_PORT = 3;
    private static final int CLOSE_GEAR_MANIPULATOR_PORT = 4;
    private static final int CLIMB_BUTTON = 9;
    private static final int TRACKING_BUTTON = 1;
    private static final int SHOOTING_BUTTON = 5;
    private static final int INTAKE_BUTTON_PORT = 8;
    private static final int SHIFT_DOWN_BUTTON = 9;
    private static final int TOGGLE_PICKUPBAR_BUTTON = 10;
    private static final int LIFT_PICKUP_BUTTON = 3;


    private final Joystick driveStick;
    private final Joystick opStick;
    private final JoystickButton trackButton;
    private final JoystickButton climbButton;
    private final JoystickButton flipOutButton;
    private final JoystickButton openButton;
    private final JoystickButton closeButton;
    private final JoystickButton flipInButton;
    private final JoystickButton intakeButton;
    private final JoystickButton shiftButton;
    private final JoystickButton shootButton;
    private final JoystickButton togglePickupBarButton;

    public OperatorInterface() {
        driveStick = new Joystick(DRIVE_JOYSTICK_PORT);
        opStick = new Joystick(OPERATOR_STICK_PORT);
        trackButton = new JoystickButton(driveStick,TRACKING_BUTTON);
        trackButton.whileHeld(new VisionDriveCommand());
        climbButton = new JoystickButton(opStick,CLIMB_BUTTON);
        climbButton.whileHeld(new ClimbUp());
        flipOutButton = new JoystickButton(opStick,FLIP_OUT_BUTTON_PORT);
        flipOutButton.whenPressed(new FlipGear(true));
        openButton = new JoystickButton(opStick,OPEN_GEAR_MANIPULATOR_PORT);
        openButton.whenPressed(new OpenGearManipulator());
        closeButton = new JoystickButton(opStick,CLOSE_GEAR_MANIPULATOR_PORT);
        closeButton.whenPressed(new CloseGearManipulator());
        flipInButton = new JoystickButton(opStick, FLIP_IN_BUTTON_PORT);
        flipInButton.whenPressed(new FlipGear(false));
        intakeButton = new JoystickButton(opStick, INTAKE_BUTTON_PORT);
        intakeButton.whileHeld(new IntakeCommand());
        shiftButton = new JoystickButton(driveStick, SHIFT_DOWN_BUTTON);
        shiftButton.whileHeld(new ShiftDown());
        shiftButton.whenInactive(new ShiftUp());
        shootButton = new JoystickButton(opStick,SHOOTING_BUTTON);
        shootButton.whileHeld(new Shoot());
        togglePickupBarButton = new JoystickButton(opStick, TOGGLE_PICKUPBAR_BUTTON);
        togglePickupBarButton.whileHeld(new BackwardsAgitatorCommand());
    }

    public double getDriveY() {
        return -driveStick.getY();
    }
    public double getDriveX(){return driveStick.getX();}

}