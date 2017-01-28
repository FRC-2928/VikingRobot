package org.usfirst.frc.team2928.commands;

import org.usfirst.frc.team2928.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class JoystickDrive extends Command {

    public JoystickDrive() {
        requires(Robot.drivebase);
    }

    @Override
    protected void execute() {
        Robot.drivebase.drive(Robot.oi.getDriveY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
