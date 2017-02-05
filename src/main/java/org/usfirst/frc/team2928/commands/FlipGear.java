package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class FlipGear extends Command{

    public FlipGear(){
        super();
        requires(Robot.gearmanipulator);
    }

    @Override
    protected void initialize(){
        Robot.gearmanipulator.flipUp();
    }

    @Override
    protected void end(){
        Robot.gearmanipulator.flipDown();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
