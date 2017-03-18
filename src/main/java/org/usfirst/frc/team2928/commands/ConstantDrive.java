package org.usfirst.frc.team2928.commands;

import org.usfirst.frc.team2928.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ConstantDrive extends Command {

    private final double output;

    public ConstantDrive(final double output, final int seconds) {
        super();
        requires(Robot.drivebase);
        setTimeout(seconds);
        this.output = output;
    }

    @Override
    protected void initialize() {
        Robot.drivebase.drive(output,0);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
