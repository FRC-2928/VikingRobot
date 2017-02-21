package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 2/21/2017.
 */
public class ShiftDown extends Command {
    public ShiftDown(){
        requires(Robot.shifter);
    }
    @Override
    protected void initialize() {
        Robot.shifter.shiftDown();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
