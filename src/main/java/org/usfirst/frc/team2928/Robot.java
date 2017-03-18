package org.usfirst.frc.team2928;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.autonomous.DriveForward;
import org.usfirst.frc.team2928.commands.ConstantDrive;
import org.usfirst.frc.team2928.subsystems.*;

/**
 * Robot for 2017.
 */
public class Robot extends IterativeRobot {

    public static final Drivebase drivebase =  new Drivebase();
    public static final GearManipulator gearmanipulator = new GearManipulator();
    public static final VisionTracking visiontracking = new VisionTracking();
    public static final RopeClimber ropeclimber = new RopeClimber();
    public static final Shooter shooter = new Shooter();
    public static final Shifter shifter = new Shifter();
    public static final Intake intake = new Intake();

    public static OperatorInterface oi;

    //TODO: add to these command groups to make the robot do anything during auto.
    private static SendableChooser<Command> autoSelector;
    private static Compressor compressor = new Compressor();

    @Override
    public void robotInit() {
        compressor.start();
        autoSelector = new SendableChooser<>();
        autoSelector.addDefault("Drive Forward", new DriveForward());
        //created this last for ordering issues
        oi = new OperatorInterface();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Left", visiontracking.getVisionLeft());
        SmartDashboard.putNumber("Right", visiontracking.getVisionRight());
    }

    @Override
    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
        new ConstantDrive(0.75, 4);
    }

    @Override
    public void autonomousPeriodic() {
        SmartDashboard.putNumber("Left", visiontracking.getVisionLeft());
        SmartDashboard.putNumber("Right", visiontracking.getVisionRight());
        Scheduler.getInstance().run();
    }
}
