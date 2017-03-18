package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Viking Robotics on 2/11/2017.
 */
public class LeftGearCommandGroup extends CommandGroup{
  private static  final CommandGroup leftAuto = new CommandGroup();
    public  LeftGearCommandGroup()
    {
        leftAuto.addSequential(new DistanceDriveCommand(183.5));
        leftAuto.addSequential(new RotateCommand(90));
        leftAuto.addSequential(new VisionDriveCommand());
        leftAuto.addSequential(new DistanceDriveCommand(69));
        leftAuto.addSequential(new OpenGearManipulator());
    }
}
