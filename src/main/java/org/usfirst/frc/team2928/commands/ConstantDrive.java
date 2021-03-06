package org.usfirst.frc.team2928.commands;

import org.usfirst.frc.team2928.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ConstantDrive extends Command {

    private final double output;

    public ConstantDrive(final double output, final double seconds) {
        super();
        requires(Robot.drivebase);
        setTimeout(seconds);
        this.output = output;
    }

    @Override
    protected void execute() {
        Robot.drivebase.drive(output, -Robot.drivebase.getGyroAngle() *.01);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
