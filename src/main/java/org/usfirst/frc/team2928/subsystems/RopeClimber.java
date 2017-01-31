package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Erika on 1/30/2017.
 */
public class RopeClimber extends Subsystem{

    private final int MOTOR_DEVICE_NUMBER = 15;

    private final CANTalon motor;

    public RopeClimber(){
        motor = new CANTalon(MOTOR_DEVICE_NUMBER);

    }

    public void drive(final double input) {
        motor.set(input);
    }

    @Override
    protected void initDefaultCommand() {}


}
