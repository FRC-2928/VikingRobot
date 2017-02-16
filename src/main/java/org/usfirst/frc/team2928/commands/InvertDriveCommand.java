package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 2/13/2017.
 */
public class InvertDriveCommand extends Command {

    public InvertDriveCommand(){
        requires(Robot.drivebase);
    }
    @Override
    protected void initialize() {
        Robot.drivebase.invertDrive();
    }
    @Override
    protected boolean isFinished() {
        return true;
    }
}
