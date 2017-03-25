package org.usfirst.frc.team2928.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2928.commands.*;

/**
 * Created by Viking Robotics on 3/24/2017.
 */
public class RightGearCommandGroup extends CommandGroup {
    RightGearCommandGroup()
    {
        addSequential(new SoftwareDistanceDrive(7.0 * 12 + 17), 6); // Get distance to align with right peg
        addSequential(new RotateCommand(-60), 4); // Turn left to face peg
        addSequential(new WaitCommand(0.2)); // Small delay after turning
        addSequential(new SoftwareDistanceDrive(2.6 * 12 - 17), 4); // Drive up to peg
        addSequential(new OpenGearManipulator()); // Drop gear
        addSequential(new WaitCommand(1)); // Wait for gear to settle
        addSequential(new ConstantDrive(-0.5, 0.5)); // Move backwards
        addSequential(new CloseGearManipulator()); // Get the robot ready for teleop
    }
}
