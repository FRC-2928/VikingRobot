package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 2/1/2017.
 */
public class IntakeCommand extends Command {
    public IntakeCommand() {
        super();
        requires(Robot.intake);
    }

    @Override
    protected void initialize(){
        SmartDashboard.putBoolean("IntakeRunning", true);
        Robot.intake.activateIntake();
    }

    @Override
    protected void execute(){
        Robot.intake.activateIntake();
    }
    @Override
    protected void end(){
        SmartDashboard.putBoolean("IntakeRunning", false);
        Robot.intake.deactivateIntake();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
