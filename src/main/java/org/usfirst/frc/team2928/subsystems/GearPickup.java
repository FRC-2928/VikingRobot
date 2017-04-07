package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearPickup extends Subsystem{


    private final int ARM_SOLENOID_PORT = 3;

    private boolean deployed = false;
    private final Solenoid arm;

    @Override
    protected void initDefaultCommand() {}

    public GearPickup(){
         arm = new Solenoid(ARM_SOLENOID_PORT);
         goDown();

    }
    public void goDown(){
        deployed = false;
        arm.set(false);
    }
    public void goUp(){
        deployed = true;
        arm.set(true);
    }
}
