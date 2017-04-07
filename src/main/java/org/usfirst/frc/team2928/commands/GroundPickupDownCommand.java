package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 4/7/2017.
 */
public class GroundPickupDownCommand extends Command {
    public GroundPickupDownCommand(){
        requires(Robot.gearpickup);
    }

    @Override
    protected void initialize() {
        super.initialize();
        Robot.gearpickup.goDown();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }


}
