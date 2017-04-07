package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team2928.Robot;

public class DistanceDrive extends PIDCommand {

    private double setpoint;
    private double rotate;
    public DistanceDrive(double inches) {
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
        Robot.drivebase.drive(output,rotate * .01);
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
    protected void execute() {
        rotate = Robot.drivebase.getGyroAngle();
    }

    @Override
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }
}
