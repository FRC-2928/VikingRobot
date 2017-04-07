package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2928.commands.*;

/**
 * Created by Viking Robotics on 3/18/2017.
 */
public class MidGearAuto extends CommandGroup {
    public MidGearAuto() {
        //NOW DOES RIGHT GEAR AUTO
        System.out.println("Placing mid gear");
        addSequential(new CloseGearManipulator());
        addSequential(new GyroDistanceDrive(7 * 12),4);
        addSequential(new WaitCommand(1));
        addSequential(new OpenGearManipulator());
        addSequential(new WaitCommand(1));
        addSequential(new ConstantDrive(-.5,1));
        //(This stays commented out) addSequential(new SoftwareDistanceDrive(-3 * 12));
        addSequential(new CloseGearManipulator());
    }
}
