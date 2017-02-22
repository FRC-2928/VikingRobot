package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class ClimbUp extends Command{

    public ClimbUp(){
        requires(Robot.ropeclimber);
    }

    @Override
    protected  void execute(){
        Robot.ropeclimber.drive(.7);
    }
    @Override
    protected void end(){
        Robot.ropeclimber.drive(0);
    }

    @Override
    protected void interrupted() {
        Robot.ropeclimber.drive(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
