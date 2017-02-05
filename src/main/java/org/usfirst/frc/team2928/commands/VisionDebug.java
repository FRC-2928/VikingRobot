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
        SmartDashboard.putBoolean("Is Locked", Robot.visiontracking.getLocked());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
