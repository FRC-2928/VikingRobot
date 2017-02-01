package org.usfirst.frc.team2928;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.JoystickBase;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2928.commands.CloseGearManipulator;
import org.usfirst.frc.team2928.commands.FlipGear;
import org.usfirst.frc.team2928.commands.OpenGearManipulator;

public class OperatorInterface {

    // TODO: Determine proper port for joystick/buttons
    private static final int DRIVE_JOYSTICK_PORT = 1;
    private static final int FLIP_BUTTON_PORT = 2;
    private static final int OPEN_GEAR_MANIPULATOR_PORT = 3;
    private static final int CLOSE_GEAR_MANIPULATOR_PORT = 4;

    private final Joystick driveStick;
    private final JoystickButton flipButtion;
    private final JoystickButton openButton;
    private final JoystickButton closeButton;

    public OperatorInterface() {
        driveStick = new Joystick(DRIVE_JOYSTICK_PORT);
        flipButtion = new JoystickButton(driveStick,FLIP_BUTTON_PORT);
        flipButtion.whileHeld(new FlipGear());
        openButton = new JoystickButton(driveStick,OPEN_GEAR_MANIPULATOR_PORT);
        openButton.whenPressed(new OpenGearManipulator());
        closeButton = new JoystickButton(driveStick,CLOSE_GEAR_MANIPULATOR_PORT);
        closeButton.whenPressed(new CloseGearManipulator());
    }

    public double getDriveY() {
        return driveStick.getY();
    }
    public double getDriveX(){return driveStick.getX();}

}