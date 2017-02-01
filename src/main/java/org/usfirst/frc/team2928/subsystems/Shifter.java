package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Viking Robotics on 2/1/2017.
 */
public class Shifter extends Subsystem {

    private static final int LEFT_SHIFT_PORT = 1;
    private static final int RIGHT_SHIFT_PORT = 2;
    private final Solenoid leftSolenoid;
    private final Solenoid rightSolenoid;

    public Shifter(){
        leftSolenoid = new Solenoid(LEFT_SHIFT_PORT);
        rightSolenoid= new Solenoid(RIGHT_SHIFT_PORT);
    }

    public void shiftUp(){
        leftSolenoid.set(false);
        rightSolenoid.set(false);
    }
    public void shiftDown(){
        leftSolenoid.set(true);
        rightSolenoid.set(true);
    }
    @Override
    protected void initDefaultCommand() {

    }
}
