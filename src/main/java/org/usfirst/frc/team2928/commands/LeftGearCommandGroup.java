package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Viking Robotics on 2/11/2017.
 */
public class LeftGearCommandGroup extends CommandGroup{
  private static  final CommandGroup leftAuto = new CommandGroup();
    public  LeftGearCommandGroup()
    {
        leftAuto.addSequential(new AutoDriveCommand());
        leftAuto.addSequential(new RotateCommand(45));
        leftAuto.addSequential(new AutoDriveCommand());
        leftAuto.addSequential(new VisionDriveCommand());
        leftAuto.addSequential(new OpenGearManipulator());
    }
}
