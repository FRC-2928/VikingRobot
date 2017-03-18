package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2928.commands.ConstantDrive;

public class DriveForward extends CommandGroup {

    public DriveForward() {
        addSequential(new ConstantDrive(1, 3));
    }
}
