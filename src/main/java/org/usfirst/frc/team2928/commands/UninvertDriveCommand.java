package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 2/13/2017.
 */
public class UninvertDriveCommand extends Command {
    public UninvertDriveCommand(){
        requires(Robot.drivebase);
    }
    @Override
    protected void initialize() {
        Robot.drivebase.uninvertDrive();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
