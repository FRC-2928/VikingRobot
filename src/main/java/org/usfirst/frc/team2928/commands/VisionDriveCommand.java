package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

public class VisionDriveCommand extends PIDCommand{

    public VisionDriveCommand(){
        super(.0125,.008,.2);
    requires(Robot.drivebase);
    getPIDController().setAbsoluteTolerance(1);
    getPIDController().setOutputRange(-.8,.8);
    setSetpoint(Robot.visiontracking.getPos());
}
    int number = 0;

    @Override
    protected void execute() {
        SmartDashboard.putNumber("New vision left", Robot.visiontracking.getVisionLeft());
        SmartDashboard.putNumber("New vision right", Robot.visiontracking.getVisionRight());
    }

    int count = 1;
    @Override
    protected void initialize(){
        Robot.drivebase.calibrateGyro();

        SmartDashboard.putNumber("Initalize Counter", number);
        number++;
    }

    @Override
    protected double returnPIDInput() {
        return Robot.drivebase.getGyroAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivebase.rotate(output);
        SmartDashboard.putNumber("PID Output",output);
    }

    @Override
    protected boolean isFinished() {
        SmartDashboard.putBoolean("Is Finished",getPIDController().onTarget());
        return getPIDController().onTarget();
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {

        getPIDController().disable();
        Robot.drivebase.drive(0,0);
    }
}
