package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

public class Rotate extends PIDCommand {

    int number = 0;

    public Rotate(double degrees) {
        super(.0125,.008,.2);
        requires(Robot.drivebase);
        getPIDController().setAbsoluteTolerance(1);
        getPIDController().setOutputRange(-.8,.8);
        setSetpoint(degrees);
        LiveWindow.addActuator("Drivebase", "RotateRelative PID Controller", getPIDController());
    }

    @Override
    protected double returnPIDInput() {
        SmartDashboard.putNumber("Yaw", Robot.drivebase.getGyroAngle());
        return Robot.drivebase.getGyroAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivebase.rotate(output);
        SmartDashboard.putNumber("PID Output",output);
    }

    @Override
    protected boolean isFinished() {
        SmartDashboard.putBoolean("Is Finished",getPIDController().onTarget());
        return getPIDController().onTarget();
    }
}