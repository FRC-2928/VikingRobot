package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2928.Robot;
import org.usfirst.frc.team2928.commands.*;

/**
 * Created by Viking Robotics on 3/18/2017.
 */
public class MidGearAuto extends CommandGroup {
    public MidGearAuto() {
        System.out.println("Placing mid gear");
        addSequential(new CalibrateGyro());
        addSequential(new CloseGearManipulator());
        addSequential(new ConstantDrive(.5, 2),2);
        addSequential(new WaitCommand(0.5));
        addSequential(new Rotate(0));
        /*addSequential(new GyroDistanceDrive(1*12),1);
        addSequential(new WaitCommand(.5));
        addSequential(new OpenGearManipulator());
        addSequential(new WaitCommand(.5));
        addSequential(new ConstantDrive(-.5,1));*/
        //(This stays commented out) addSequential(new SoftwareDistanceDrive(-3 * 12));
        addSequential(new CloseGearManipulator());
    }
}
