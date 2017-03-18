package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team2928.Robot;

public class AutoDriveCommand extends PIDCommand {
    private double setInches;

    public AutoDriveCommand(double setInches) {
        super(.3,0,0);
        requires(Robot.drivebase);
        this.setInches = setInches;
        setSetpoint(Robot.drivebase.setSetpoint(setInches));
        getPIDController().setAbsoluteTolerance(Robot.drivebase.setSetpoint(1));
        getPIDController().setOutputRange(-.8,.8);

    }

    @Override
    protected void initialize() {
        Robot.drivebase.autoDriveSetup();

    }



    @Override
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }

    @Override
    protected void end() {
        Robot.drivebase.drive(0, 0);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivebase.autoDrive(output);
    }

    @Override
    protected double returnPIDInput() {
        //double pos = (Robot.drivebase.getRightTalon().getEncPosition() + Robot.drivebase.getLeftTalon().getEncPosition())/2;
        return 0;
    }
}
