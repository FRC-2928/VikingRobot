package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

public class Shoot extends Command {
    public Shoot(){
        super();
        requires(Robot.shooter);
        requires(Robot.gearmanipulator);
    }
 @Override
    protected void initialize()
    {
        Robot.gearmanipulator.flipDown();
    }



    @Override
    protected void execute() {
        double targetSpeed = .75* 1500;
        Robot.shooter.setSetpoint(.75*1500);
        SmartDashboard.putNumber("Setpoint Set",targetSpeed);

            Robot.shooter.agitate();


    }

    @Override
    protected void interrupted() {
        Robot.shooter.stopMotor();
        Robot.shooter.stopAgitation();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
