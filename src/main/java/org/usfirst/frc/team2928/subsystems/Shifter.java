package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifter extends Subsystem {

    private static final int SHIFT_PORT = 1;
    private final Solenoid shiftSolenoid;

    public Shifter(){
        shiftSolenoid = new Solenoid(SHIFT_PORT);
    }

    //Sets the shift up
    public void shiftUp(){
        shiftSolenoid.set(false);
    }
    //Sets the shift down
    public void shiftDown(){
        shiftSolenoid.set(true);
    }
    @Override
    protected void initDefaultCommand() {

    }
}
