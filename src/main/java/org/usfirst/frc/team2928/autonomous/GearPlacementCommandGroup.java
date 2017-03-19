package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2928.commands.CloseGearManipulator;
import org.usfirst.frc.team2928.commands.ConstantDrive;
import org.usfirst.frc.team2928.commands.OpenGearManipulator;

/**
 * Created by Viking Robotics on 3/18/2017.
 */
public class GearPlacementCommandGroup extends CommandGroup {
    GearPlacementCommandGroup() {
        addSequential(new ConstantDrive(0.75, 3.5));
        addSequential(new OpenGearManipulator());
        addSequential(new WaitCommand(0.3));
        addSequential(new ConstantDrive(-.6, 1));
        addSequential(new CloseGearManipulator());
    }
}
