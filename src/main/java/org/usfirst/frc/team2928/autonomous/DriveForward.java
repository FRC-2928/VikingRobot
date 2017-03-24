package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2928.commands.ConstantDrive;
import org.usfirst.frc.team2928.commands.DistanceDriveCommand;
import org.usfirst.frc.team2928.commands.RotateCommand;
import org.usfirst.frc.team2928.commands.SoftwareDistanceDrive;

public class DriveForward extends CommandGroup {

    public DriveForward() {
        //addSequential(new ConstantDrive(0.75, 4));
        addSequential(new SoftwareDistanceDrive(72));
    }
}
