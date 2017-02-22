package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeClimber extends Subsystem{

    private final int MOTOR_DEVICE_NUMBER = 10;

    private final CANTalon motor;

    public RopeClimber(){
        motor = new CANTalon(MOTOR_DEVICE_NUMBER);

    }

    public void drive(final double input) {
        motor.set(-input);
    }

    @Override
    protected void initDefaultCommand() {}


}
