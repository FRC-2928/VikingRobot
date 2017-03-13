package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

public class RotateCommand extends PIDCommand {

    public RotateCommand(double setpoint) {
        super(.007,0,0);
        requires(Robot.drivebase);
        getPIDController().setAbsoluteTolerance(1);
        getPIDController().setOutputRange(-.8,.8);
        setSetpoint(setpoint);
        LiveWindow.addActuator("Drivebase", "Rotate PID Controller", getPIDController());
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
        return Robot.drivebase.getGyroAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivebase.rotate(-output);
        SmartDashboard.putNumber("PID Output",output);
    }

    @Override
    protected boolean isFinished() {
        SmartDashboard.putBoolean("Is Finished",getPIDController().onTarget());
        return getPIDController().onTarget();
    }
}