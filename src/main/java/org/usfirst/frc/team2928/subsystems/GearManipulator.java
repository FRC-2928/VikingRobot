package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Max on 1/28/2017.
 */
public class GearManipulator extends Subsystem{

    private final int LEFT_ARM_SOLENOID_PORT = 1;
    private final int RIGHT_ARM_SOLENOID_PORT = 2;
    private final int LEFT_FLIPPER_SOLENOID_PORT = 3;
    private final int RIGHT_FLIPPER_SOLENOID_PORT = 4;

    private boolean closed = false;
    private final Solenoid lArm;
    private final Solenoid rArm;
    private final Solenoid lFlipper;
    private final Solenoid rFlipper;

    @Override
    protected void initDefaultCommand() {}

    public GearManipulator(){
         lArm = new Solenoid(LEFT_ARM_SOLENOID_PORT);
         rArm = new Solenoid(RIGHT_ARM_SOLENOID_PORT);
         lFlipper = new Solenoid(LEFT_FLIPPER_SOLENOID_PORT);
         rFlipper = new Solenoid(RIGHT_FLIPPER_SOLENOID_PORT);
         close();

    }
    public void close(){
        closed = true;
        lArm.set(true);
        rArm.set(true);
    }
    public void open(){
        closed = false;
        lArm.set(false);
        rArm.set(false);
    }
    public void flipUp(){
        if(closed){
            lFlipper.set(true);
            rFlipper.set(true);
        }
    }
    public void flipDown(){
        lFlipper.set(false);
        rFlipper.set(false);
    }
}
