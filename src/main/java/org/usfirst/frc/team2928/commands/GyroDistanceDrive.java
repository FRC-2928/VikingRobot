package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Viking Robotics on 3/26/2017.
 */
public class GyroDistanceDrive extends CommandGroup{

    public GyroDistanceDrive(double output)
    {
        addSequential(new CalibrateGyro());
        addSequential(new DistanceDrive(output * 0.8));
        addSequential(new Rotate(0));
    }
}
