package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 2/1/2017.
 */
public class VisionDriveCommand extends PIDCommand {
    public VisionDriveCommand()
    {
        super(.5,0,0);
        requires(Robot.drivebase);
        requires(Robot.visiontracking);
        getPIDController().setAbsoluteTolerance(1);
        getPIDController().setOutputRange(-.6,.6);
        getPIDController().setSetpoint(Robot.visiontracking.getPos());
    }

    @Override
    protected double returnPIDInput() {
        return Robot.drivebase.getGyroAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivebase.visionDrive(output);
    }

    protected void initialize() {
        Robot.drivebase.calibrateGyro();
    }

    protected void execute()
    {

    }

    protected boolean isFinished() {
    return getPIDController().onTarget();
    }
}
