package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2928.commands.CloseGearManipulator;
import org.usfirst.frc.team2928.commands.ConstantDrive;
import org.usfirst.frc.team2928.commands.OpenGearManipulator;
import org.usfirst.frc.team2928.commands.SoftwareDistanceDrive;

/**
 * Created by Viking Robotics on 3/18/2017.
 */
public class GearPlacementCommandGroup extends CommandGroup {
    public GearPlacementCommandGroup() {
        System.out.println("Placing mid gear");
        addSequential(new CloseGearManipulator());
        addSequential(new SoftwareDistanceDrive(7.0 * 12));
        addSequential(new WaitCommand(1));
        addSequential(new OpenGearManipulator());
        addSequential(new WaitCommand(1));
        addSequential(new ConstantDrive(-.5,0.75));
        //addSequential(new SoftwareDistanceDrive(-3 * 12));
        addSequential(new CloseGearManipulator());
    }
}
