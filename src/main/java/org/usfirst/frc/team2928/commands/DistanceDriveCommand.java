package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class DistanceDriveCommand extends Command {

    private double revolutions;

    public DistanceDriveCommand(double revolutions) {
        super();
        requires(Robot.drivebase);
        this.revolutions = revolutions;
    }


    @Override
    protected void initialize() {
        Robot.drivebase.setDistanceMode();
        Robot.drivebase.initPosition();
    }

    @Override
    protected void execute() {
        Robot.drivebase.driveDistance(revolutions);
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
