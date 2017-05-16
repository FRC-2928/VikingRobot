package org.usfirst.frc.team2928;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.commands.*;

import java.util.ArrayList;

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

    private ArrayList<JoystickButton> buttons = new ArrayList<JoystickButton>();

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
    private final JoystickButton groundGearOut;
    private final JoystickButton togglePickupBarButton;

    public OperatorInterface() {

        driveStick = new Joystick(DRIVE_JOYSTICK_PORT);
        opStick = new Joystick(OPERATOR_STICK_PORT);
        groundGearOut = new JoystickButton(opStick, 420);
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
       // intakeButton.whileHeld(new IntakeCommand());
        intakeButton.whileHeld(new GroundPickupDown());
        intakeButton.whenInactive(new GroundPickupUpCommand());
        shiftButton = new JoystickButton(driveStick, SHIFT_DOWN_BUTTON);
        shiftButton.whileHeld(new ShiftDown());
        shiftButton.whenInactive(new ShiftUp());
        shootButton = new JoystickButton(opStick,SHOOTING_BUTTON);
        shootButton.whileHeld(new Shoot());
        togglePickupBarButton = new JoystickButton(opStick, TOGGLE_PICKUPBAR_BUTTON);
        togglePickupBarButton.whileHeld(new IntakeCommand());

        //TODO: COMMENT THIS OUT OR EVERYTHING GOES TO SHIT
        /*while (trackButton.get() || climbButton.get() || flipOutButton.get() || openButton.get() || closeButton.get()
                || flipInButton.get() || intakeButton.get() || shiftButton.get() || shootButton.get() || togglePickupBarButton.get()){
            buttons.add(trackButton);
            buttons.add(climbButton);
            buttons.add(flipInButton);
            buttons.add(flipOutButton);
            buttons.add(openButton);
            buttons.add(closeButton);
            buttons.add(intakeButton);
            buttons.add(shiftButton);
            buttons.add(shootButton);
            buttons.add(togglePickupBarButton);
            int[] rands = new int[10];
            for(int i=0;i<10;i++){
                rands[i] = (int)Math.floor(Math.random()*10 + 1);
                JoystickButton butan = buttons.get(i);
                butan = new JoystickButton(opStick, rands[i]);
            }
        }*/
    }

    public double getDriveY() {
        return -driveStick.getY();
    }
    public double getDriveX(){return driveStick.getX();}

}