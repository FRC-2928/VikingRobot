package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 3/23/2017.
 */
public class SoftwareDistanceDrive extends PIDCommand {
    double setpoint;
    public SoftwareDistanceDrive(double inches) {
        super(0.0003, 0, 0);
        requires(Robot.drivebase);
        this.setpoint = Robot.drivebase.inchesToEncTics(inches);
    }

    @Override
    protected double returnPIDInput() {
        double enc = Robot.drivebase.getEncPosition();
        System.out.println("Left encoder position: " + enc);
        return enc;
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivebase.drive(output, 0);
    }

    @Override
    protected void initialize() {
        super.initialize();
        Robot.drivebase.setBrakeMode(true);
        Robot.drivebase.initPosition();
        getPIDController().setSetpoint(setpoint);
        System.out.println("Setpoint: " + setpoint);
        getPIDController().setOutputRange(-.85,.85);
        getPIDController().setAbsoluteTolerance(102);
    }


    @Override
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }
}
