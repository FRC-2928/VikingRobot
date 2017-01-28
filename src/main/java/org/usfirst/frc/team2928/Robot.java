package org.usfirst.frc.team2928;

import org.usfirst.frc.team2928.commands.ConstantDrive;
import org.usfirst.frc.team2928.subsystems.Drivebase;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * Robot for the test platform.
 */
public class Robot extends IterativeRobot {

    public static Drivebase drivebase;
    public static OperatorInterface oi;

    @Override
    public void robotInit() {
        oi = new OperatorInterface();
        drivebase = new Drivebase();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        new ConstantDrive(.1).start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
}
