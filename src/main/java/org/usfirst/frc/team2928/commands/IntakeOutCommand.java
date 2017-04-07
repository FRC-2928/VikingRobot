package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 4/7/2017.
 */
public class IntakeOutCommand extends Command {

    public IntakeOutCommand(){
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        Robot.intake.reverseIntkae();
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {Robot.intake.deactivateIntake();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
