package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class AutomaticShift extends Command {
    public AutomaticShift(){
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
