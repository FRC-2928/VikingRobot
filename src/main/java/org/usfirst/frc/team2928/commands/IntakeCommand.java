package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 2/1/2017.
 */
public class IntakeCommand extends Command {
    public IntakeCommand() {
        super();
    }

    @Override
    protected void initialize(){
        Robot.intake.activateIntake();
    }

    @Override
    protected void end(){
        Robot.intake.deactivateIntake();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
