package org.usfirst.frc.team2928;

import org.usfirst.frc.team2928.commands.ConstantDrive;
import org.usfirst.frc.team2928.commands.VisionDebug;
import org.usfirst.frc.team2928.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * Robot for the test platform.
 */
public class Robot extends IterativeRobot {

    public static Drivebase drivebase;
    public static OperatorInterface oi;
    public static GearManipulator gearmanipulator;
    public static VisionTracking visiontracking;
    public static RopeClimber ropeclimber;
    public static Shooter shooter;
    public static Shifter shifter;
    public static Intake intake;
    @Override
    public void robotInit() {
        drivebase = new Drivebase();
        //gearmanipulator = new GearManipulator();
        visiontracking = new VisionTracking();
        oi = new OperatorInterface();
        //ropeclimber = new RopeClimber();
        //shooter = new Shooter();
        //shifter = new Shifter();
        //intake = new Intake();
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
