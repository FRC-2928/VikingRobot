package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class Shoot extends Command {
    public Shoot(){
        super();
        requires(Robot.shooter);
    }


    @Override
    protected void execute() {
        double targetSpeed = Robot.oi.getDriveY() * 1500;
        Robot.shooter.setSetpoint(targetSpeed);
        if((Robot.shooter.getVelocity() > targetSpeed-100)||Robot.shooter.getVelocity()<targetSpeed+100)
        {
            Robot.shooter.agitate();
        }
        else
        {
            Robot.shooter.stopAgitation();
        }
    }



    @Override
    protected boolean isFinished() {
        return false;
    }
}
