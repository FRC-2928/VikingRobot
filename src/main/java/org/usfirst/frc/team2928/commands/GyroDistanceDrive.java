package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 3/26/2017.
 */
public class GyroDistanceDrive extends CommandGroup{

    public GyroDistanceDrive(double output)
    {
        addSequential(new CalibrateGyro());
        addSequential(new DistanceDrive(output * 0.8));
       // double rotate = Robot.drivebase.getGyroAngle();
       // addSequential(new Rotate( rotate));
    }
}
