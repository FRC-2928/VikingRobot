package org.usfirst.frc.team2928;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorInterface {

    // TODO: Determine proper port for joystick
    private static final int DRIVE_JOYSTICK_PORT = 1;

    private final Joystick driveStick;

    public OperatorInterface() {
        driveStick = new Joystick(DRIVE_JOYSTICK_PORT);
    }

    public double getDriveY() {
        return driveStick.getY();
    }

}