package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Max on 1/28/2017.
 */
public class GearManipulator extends Subsystem{

    private boolean closed = false;
    private final Solenoid lArm;
    private final Solenoid rArm;
    private final Solenoid lFlipper;
    private final Solenoid rFlipper;

    @Override
    protected void initDefaultCommand() {

    }
    public GearManipulator(){
         lArm = new Solenoid(/*CHANNEL*/);
         rArm = new Solenoid(/*CHANNEL*/;
         lFlipper = new Solenoid(/*CHANNEL*/);
         rFlipper = new Solenoid(/*CHANNEL*/);
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
