package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 2/6/2017.
 */
public class AutoDriveCommand extends Command {
    double setInches;

    public AutoDriveCommand(double setInches){
        this.setInches = setInches;
        requires(Robot.autoDrive);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected void initialize(){
        Robot.autoDrive.setSetpoint(setInches);
    }

    @Override
    protected boolean isFinished() {
        return (Robot.autoDrive.getLeftTalon().getClosedLoopError()<.5)&&(Robot.autoDrive.getRightTalon().getClosedLoopError()<.5);
    }
}
