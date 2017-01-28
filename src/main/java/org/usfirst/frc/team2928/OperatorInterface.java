package org.usfirst.frc.team2928;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.JoystickBase;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2928.commands.CloseGearManipulator;
import org.usfirst.frc.team2928.commands.FlipGear;
import org.usfirst.frc.team2928.commands.OpenGearManipulator;

public class OperatorInterface {

    // TODO: Determine proper port for joystick
    private static final int DRIVE_JOYSTICK_PORT = 1;

    private final Joystick driveStick;
    private final JoystickButton flipButtion;
    private final JoystickButton openButton;
    private final JoystickButton closeButton;

    public OperatorInterface() {
        driveStick = new Joystick(DRIVE_JOYSTICK_PORT);
        flipButtion = new JoystickButton(driveStick,/*BUTTON_NUMBER*/);
        flipButtion.whileHeld(new FlipGear());
        openButton = new JoystickButton(driveStick,/*BUTTON_NUMBER*/);
        openButton.whenPressed(new OpenGearManipulator());
        closeButton = new JoystickButton(driveStick,/*BUTTON_NUMBER*/);
        closeButton.whenPressed(new CloseGearManipulator());
    }

    public double getDriveY() {
        return driveStick.getY();
    }

}