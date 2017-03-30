package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

public class RotateRelative extends CommandGroup {

    public RotateRelative(double degrees) {
        addSequential(new CalibrateGyro());
        addSequential(new Rotate(degrees));
    }
}