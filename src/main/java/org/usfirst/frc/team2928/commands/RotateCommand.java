package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team2928.Robot;

public class RotateCommand extends PIDCommand {

    public RotateCommand(double setpoint) {
        super(.5,0,0);
        requires(Robot.drivebase);
        getPIDController().setAbsoluteTolerance(1);
        getPIDController().setOutputRange(-.6,.6);
        setSetpoint(setpoint);
        LiveWindow.addActuator("Drivebase", "Rotate PID Controller", getPIDController());
    }

    @Override
    protected void initialize(){
        Robot.drivebase.calibrateGyro();
    }

    @Override
    protected double returnPIDInput() {
        return Robot.drivebase.getGyroAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivebase.rotate(output);
    }

    @Override
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }
}