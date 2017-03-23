package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2928.commands.DistanceDriveCommand;
import org.usfirst.frc.team2928.commands.OpenGearManipulator;
import org.usfirst.frc.team2928.commands.RotateCommand;
import org.usfirst.frc.team2928.commands.Shoot;

/**
 * Created by Viking Robotics on 3/22/2017.
 */
public class GearShooterAuto extends CommandGroup {
    GearShooterAuto()
    {
        addSequential(new DistanceDriveCommand(4)); // Drive forwards to gear
        addSequential(new RotateCommand(-30));
        addSequential(new WaitCommand(0.3)); // Face Gear
        addSequential(new DistanceDriveCommand(2)); // Drive towards gear
        addSequential(new OpenGearManipulator());
        addSequential(new WaitCommand(0.5));
        addSequential(new DistanceDriveCommand(-2));
        addSequential(new RotateCommand(180));
        addSequential(new DistanceDriveCommand(2));
        addSequential(new Shoot(), 2);
    }
}
