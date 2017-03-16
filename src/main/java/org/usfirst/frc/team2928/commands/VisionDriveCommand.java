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
    int count = 1;
    @Override
    protected void initialize(){
        Robot.drivebase.calibrateGyro();

        SmartDashboard.putNumber("Initalize Counter", number);
        number++;
    }

    @Override
    protected double returnPIDInput() {
        SmartDashboard.putNumber("Yaw", Robot.drivebase.getGyroAngle());
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
}
