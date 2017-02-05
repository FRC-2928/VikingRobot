package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class ClimbUp extends Command{

    public ClimbUp(){
        super();
        requires(Robot.ropeclimber);
    }

    @Override
    protected void initialize(){
        Robot.ropeclimber.drive(1);
    }

    protected void end(){
        Robot.ropeclimber.drive(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
