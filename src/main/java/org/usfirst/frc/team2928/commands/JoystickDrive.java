package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class JoystickDrive extends Command {

    public JoystickDrive() {
        requires(Robot.drivebase);
    }

    @Override
    protected void execute() {
        Robot.drivebase.drive(Robot.oi.getDriveX(),Robot.oi.getDriveY());
        SmartDashboard.putNumber("Gyro Angle", Robot.drivebase.getGyroAngle());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
