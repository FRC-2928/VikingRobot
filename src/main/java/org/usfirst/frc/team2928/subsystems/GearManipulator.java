package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearManipulator extends Subsystem{


    private final int ARM_SOLENOID_PORT = 2;
    private final int FLIPPER_SOLENOID_PORT = 0;

    private boolean closed = false;
    private final Solenoid arm;
    private final Solenoid flipper;

    @Override
    protected void initDefaultCommand() {}

    public GearManipulator(){
         arm = new Solenoid(ARM_SOLENOID_PORT);
         flipper = new Solenoid(FLIPPER_SOLENOID_PORT);
         close();

    }
    public void close(){
        closed = false;
        arm.set(false);
    }
    public void open(){
        closed = true;
        arm.set(true);
    }
    public void flipUp(){
        flipper.set(true);
    }
    public void flipDown(){
        flipper.set(false);
    }
}
