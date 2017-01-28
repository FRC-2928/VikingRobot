package org.usfirst.frc.team2928.commands;

import org.usfirst.frc.team2928.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ConstantDrive extends Command {

    private final double output;

    public ConstantDrive(final double output) {
        super();
        requires(Robot.drivebase);
        this.output = output;
    }

    @Override
    protected void initialize() {
        Robot.drivebase.drive(output);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
