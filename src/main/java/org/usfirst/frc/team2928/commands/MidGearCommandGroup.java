package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Viking Robotics on 2/11/2017.
 */
public class MidGearCommandGroup extends CommandGroup {
    private static final CommandGroup midAuto = new CommandGroup();
    public MidGearCommandGroup(){
        midAuto.addSequential(new AutoDriveCommand());
        midAuto.addSequential(new VisionDriveCommand());
        midAuto.addSequential(new OpenGearManipulator());
    }
}
