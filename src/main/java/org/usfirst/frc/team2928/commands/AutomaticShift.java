package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;
import org.usfirst.frc.team2928.subsystems.Shifter;

/**
 * Created by Viking Robotics on 2/1/2017.
 */
public class AutomaticShift extends Command {
    public AutomaticShift(){
        requires(Robot.shifter);
    }

    @Override
    protected void initialize() {
        if(Robot.drivebase.getEncoderVelocity() > 1500){
            Robot.shifter.shiftUp();
        }
        else{ Robot.shifter.shiftDown();}

    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
