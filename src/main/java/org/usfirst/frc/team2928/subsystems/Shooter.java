package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Viking Robotics on 2/1/2017.
 */
public class Shooter extends Subsystem {

    private static final int LEAD_SHOOTER_PORT = 14;
    private static final int FOLLOWER_SHOOTER_PORT = 15;

    private final CANTalon motor;

    public Shooter(){

        motor = new CANTalon(LEAD_SHOOTER_PORT);
        CANTalon follower = new CANTalon(FOLLOWER_SHOOTER_PORT);
        motor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        motor.changeControlMode(CANTalon.TalonControlMode.Speed);
        follower.changeControlMode(CANTalon.TalonControlMode.Follower);
        motor.setF(0);
        motor.setP(0);
        motor.setI(.00001);
        motor.setD(0);
    }

    public void setSetpoint(double setpoint){motor.set(setpoint);}

    @Override
    protected void initDefaultCommand() {

    }
}
