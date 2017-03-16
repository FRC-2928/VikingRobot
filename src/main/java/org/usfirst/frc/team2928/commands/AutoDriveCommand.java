package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

/**
 * Created by Viking Robotics on 2/6/2017.
 */
public class AutoDriveCommand extends Command {
    private double setInches;

    public AutoDriveCommand(double setInches){
        requires(Robot.drivebase);
        this.setInches = setInches;
    }

    @Override
    protected void initialize(){
        Robot.drivebase.autoDriveSetup();
        Robot.drivebase.setSetpoint(setInches);
    }
    @Override
    protected void execute() {
       Robot.drivebase.autoDrive();
    }
    @Override
    protected boolean isFinished() {
        return (Robot.drivebase.getLeftTalon().getClosedLoopError()<.5)&&(Robot.drivebase.getRightTalon().getClosedLoopError()<.5);
    }

    @Override
    protected void end() {
        Robot.drivebase.newRobotDrive();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
