package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class PickupGear extends Command{
    private boolean armUp;
    public PickupGear(boolean up){
        super();
        requires(Robot.someArmThing);
        fliperUp = up;
    }

    @Override
    protected void initialize(){
        if(armUp) {
            Robot.someArmThing.open();
            Robot.someArmThing.close();
        }
        else {

            Robot.someArmThing.flipDown();
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
