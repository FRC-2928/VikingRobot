package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 4/7/2017.
 */
public class GroundPickupUpCommand extends Command {
    public GroundPickupUpCommand(){
        requires(Robot.gearpickup);
    }

    @Override
    protected void initialize() {
        Robot.gearpickup.goUp();
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
}
