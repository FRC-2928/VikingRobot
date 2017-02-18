package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team2928.Robot;

public class VisionDriveCommand extends PIDCommand {

    public VisionDriveCommand()
    {
        super(.5,0,0);
        requires(Robot.drivebase);
        requires(Robot.visiontracking);
        getPIDController().setAbsoluteTolerance(0.25);
        getPIDController().setOutputRange(-.5,.5);
        getPIDController().setSetpoint(0);
        LiveWindow.addActuator("Drivebase", "Vision PID Controller", getPIDController());
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
        if (Robot.visiontracking.getLockedLeft() || Robot.visiontracking.getLockedRight()) {
            getPIDController().enable();
        } else {
            getPIDController().disable();
            Robot.drivebase.drive(Robot.oi.getDriveX(),Robot.oi.getDriveY());
        }
    }

    @Override
    protected void end() {
        //Robot.drivebase.stop();
    }

    protected boolean isFinished() {
    return getPIDController().onTarget();
    }
}
