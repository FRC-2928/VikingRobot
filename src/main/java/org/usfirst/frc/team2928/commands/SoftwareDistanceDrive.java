package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team2928.Robot;

public class SoftwareDistanceDrive extends PIDCommand {

    private double setpoint;

    public SoftwareDistanceDrive(double inches) {
        super(0.00007, 0.0000001, 0);
        requires(Robot.drivebase);
        this.setpoint = Robot.drivebase.inchesToEncTics(inches);
    }

    @Override
    protected double returnPIDInput() {
        return Robot.drivebase.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivebase.drive(output,0);
    }

    @Override
    protected void initialize() {
        super.initialize();
        Robot.drivebase.setBrakeMode(true);
        Robot.drivebase.initPosition();
        getPIDController().setSetpoint(setpoint);
        getPIDController().setOutputRange(-.65,.65);
        getPIDController().setAbsoluteTolerance(102);
    }

    @Override
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }
}
