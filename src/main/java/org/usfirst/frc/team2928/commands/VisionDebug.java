package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

public class VisionDebug extends Command{

    public VisionDebug(){
        super();
        requires(Robot.visiontracking);
    }

    protected void execute(){
        SmartDashboard.putBoolean("Right Camera Locked", Robot.visiontracking.getLockedRight());
        SmartDashboard.putBoolean("Left Camera Locked", Robot.visiontracking.getLockedLeft());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
