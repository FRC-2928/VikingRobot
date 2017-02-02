package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Viking Robotics on 2/1/2017.
 */
public class Intake extends Subsystem {

    private final int TALON_NUMBER = 1;
    private final CANTalon talon;

    public Intake() {
        super();
        talon = new CANTalon(TALON_NUMBER);
    }

    public void activateTalon(){
        talon.set(1);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
