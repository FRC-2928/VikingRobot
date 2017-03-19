package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
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
    protected boolean isFinished() {
        return Robot.drivebase.isOnPoint();
    }

    @Override
    protected void end() {
        Robot.drivebase.drive(0, 0);
        Robot.drivebase.setDefaultMode();
    }
}
