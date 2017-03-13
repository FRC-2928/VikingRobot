package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

public class VisionDriveCommand extends Command{

    public VisionDriveCommand()
    {

    }
    @Override
    protected void execute() {
        SmartDashboard.putNumber("Vision Position", Robot.visiontracking.getPos());
        SmartDashboard.putBoolean("On Target", Robot.drivebase.onTarget());
        new RotateCommand(Robot.visiontracking.getPos()).start();

    }

    @Override
    protected void end() {
        Robot.drivebase.drive(0,0);
    }
    @Override
    protected boolean isFinished() {
    return Robot.drivebase.onTarget();
    }
}
