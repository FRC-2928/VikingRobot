package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 3/26/2017.
 */
public class CalibrateGyro extends Command {

    public CalibrateGyro()
    {
        super();
        requires(Robot.drivebase);
    }

    @Override
    public void initialize()
    {
        Robot.drivebase.calibrateGyro();
    }
    @Override
    public boolean isFinished()
    {
        return true;
    }
}
