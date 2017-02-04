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
        getPIDController().setAbsoluteTolerance(0.1);
        getPIDController().setOutputRange(-.5,.5);
        getPIDController().setSetpoint(0);
    }

    @Override
    protected double returnPIDInput() {
        return Robot.visiontracking.getPos();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivebase.drive(-output,0);
    }

    protected void execute() {
        if (Robot.visiontracking.getLocked()) {
            getPIDController().enable();
        } else {
            getPIDController().disable();
            Robot.drivebase.drive(Robot.oi.getDriveX(),Robot.oi.getDriveY());
        }
    }

    protected boolean isFinished() {
    return getPIDController().onTarget();
    }
}
