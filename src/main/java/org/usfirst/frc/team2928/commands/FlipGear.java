package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class FlipGear extends Command{
    private boolean fliperUp;
    public FlipGear(boolean up){
        super();
        requires(Robot.gearmanipulator);
        fliperUp = up;
    }

    @Override
    protected void initialize(){
        if(fliperUp) {
            Robot.gearmanipulator.flipUp();
        }
        else {
            Robot.gearmanipulator.flipDown();
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
