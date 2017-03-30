package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2928.commands.*;

/**
 * Created by Viking Robotics on 3/26/2017.
 */
public class BlueShootAuto extends CommandGroup {

    public BlueShootAuto()
    {
        addSequential(new Shoot(), 4);
        addSequential(new BackwardsAgitatorCommand(), 0.5);
        addSequential(new Shoot(), 4);
        addSequential(new BackwardsAgitatorCommand(), 0.5);
        addSequential(new ConstantDrive(-0.4, 1));
        addSequential(new RotateRelative(-60), 1.5);
        addSequential(new WaitCommand(0.3));
        addSequential(new DistanceDrive(9 * 12));
    }
}
