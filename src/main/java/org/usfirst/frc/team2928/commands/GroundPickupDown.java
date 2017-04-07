package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Created by Viking Robotics on 4/7/2017.
 */
public class GroundPickupDown extends CommandGroup {
    public  GroundPickupDown(){
        addParallel(new GroundPickupDownCommand());
        addParallel(new IntakeOutCommand());
    }
}
