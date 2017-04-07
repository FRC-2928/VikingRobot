package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class PickupGear extends Command{
    private boolean armUp;
    public PickupGear(boolean up){
        super();
        requires(Robot.gearpickup);
        armUp = up;
    }

    @Override
    protected void initialize(){
        if(armUp) {
            Robot.gearpickup.goDown();
        }
        else {

            Robot.gearpickup.goUp();
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
