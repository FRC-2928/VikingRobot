package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class DistanceDriveCommand extends Command {

    private double setInches;

    public DistanceDriveCommand(double setInches) {
        super();
        requires(Robot.drivebase);
        this.setInches = setInches;
    }

    
    @Override
    protected void initialize() {
        Robot.drivebase.setDistanceMode();
        Robot.drivebase.initPosition();
    }

    @Override
    protected void execute() {
        Robot.drivebase.driveDistance(setInches / (4*Math.PI));
    }

    @Override
    protected boolean isFinished() {
        return false/* && Robot.drivebase.isOnPoint()*/;
    }

    @Override
    protected void end() {
        Robot.drivebase.drive(0, 0);
        Robot.drivebase.setDefaultMode();
    }
}
