package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private static final int LEAD_SHOOTER_PORT = 7;
    private static final int FOLLOWER_SHOOTER_PORT = 6;
    private static final int AGITATOR_PORT = 0;

    private final CANTalon motor;
    private final Talon agitatorMotor;

    public Shooter() {
        motor = new CANTalon(LEAD_SHOOTER_PORT);
        motor.setInverted(true);
        CANTalon follower = new CANTalon(FOLLOWER_SHOOTER_PORT);
        agitatorMotor = new Talon(AGITATOR_PORT);
        motor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        motor.changeControlMode(CANTalon.TalonControlMode.Speed);
        follower.changeControlMode(CANTalon.TalonControlMode.Follower);
        follower.set(LEAD_SHOOTER_PORT);
        motor.setF(0);
        motor.setP(.88);
        motor.setI(0);
        motor.setD(0);
    }

    public double error() {
        return motor.getClosedLoopError();
    }

    public double getVelocity() {
        return motor.getEncVelocity();
    }

    public void stopMotor() {
        motor.set(0);
    }

    public void agitate() {
        agitatorMotor.set(.6);
    }

    public void stopAgitation() {
        agitatorMotor.set(0);
    }

    public void setSetpoint(double setpoint) {
        motor.set(setpoint);
    }

    public void runAgitator(double output) {
        agitatorMotor.set(output);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
