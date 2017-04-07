package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2928.commands.*;

public class RightGearAuto extends CommandGroup {
    public RightGearAuto() {
        System.out.println("Placing right gear");
        addSequential(new CloseGearManipulator());
        addSequential(new GyroDistanceDrive(7 * 12),4);
        addSequential(new WaitCommand(1));
        addSequential(new RotateRelative(-60), 4); // Turn left to face peg
        addSequential(new WaitCommand(0.4)); // Small delay after turning
        addSequential(new GyroDistanceDrive(2.6 * 12 ), 4); // Drive up to peg
        addSequential(new OpenGearManipulator()); // Drop gear
        addSequential(new WaitCommand(1)); // Wait for gear to settle
        addSequential(new ConstantDrive(-0.5, 0.5)); // Move backwards
        addSequential(new CloseGearManipulator()); // Get the robot ready for teleop
    }
}
