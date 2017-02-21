package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private static final int LEAD_SHOOTER_PORT = 7;
    private static final int FOLLOWER_SHOOTER_PORT = 6;

    private final CANTalon motor;

    public Shooter(){

        motor = new CANTalon(LEAD_SHOOTER_PORT);
        CANTalon follower = new CANTalon(FOLLOWER_SHOOTER_PORT);
        motor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        motor.changeControlMode(CANTalon.TalonControlMode.Speed);
        follower.changeControlMode(CANTalon.TalonControlMode.Follower);
        follower.set(LEAD_SHOOTER_PORT);
        motor.setF(0);
        motor.setP(.00001);
        motor.setI(0);
        motor.setD(0);
    }

    public void setSetpoint(double setpoint){motor.set(setpoint);}

    @Override
    protected void initDefaultCommand() {

    }
}
