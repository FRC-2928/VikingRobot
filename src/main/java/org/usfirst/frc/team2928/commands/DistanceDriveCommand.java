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
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.drivebase.getPosition()) < 0.2;
    }

    @Override
    protected void end() {
        Robot.drivebase.drive(0, 0);
    }
}
