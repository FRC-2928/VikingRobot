package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Viking Robotics on 2/11/2017.
 */
public class RightGearCommandGroup extends CommandGroup {
  private static  final CommandGroup rightAuto = new CommandGroup();
  public RightGearCommandGroup() {
      rightAuto.addSequential(new AutoDriveCommand());
      rightAuto.addSequential(new RotateCommand(-45));
      rightAuto.addSequential(new AutoDriveCommand());
      rightAuto.addSequential(new VisionDriveCommand());
      rightAuto.addSequential(new OpenGearManipulator());
  }
}
