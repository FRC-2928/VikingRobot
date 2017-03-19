package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2928.commands.ConstantDrive;
import org.usfirst.frc.team2928.commands.DistanceDriveCommand;

public class DriveForward extends CommandGroup {

    public DriveForward() {
        addSequential(new ConstantDrive(0.75, 4));
    }
}
