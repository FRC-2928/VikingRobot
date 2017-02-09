package org.usfirst.frc.team2928;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team2928.commands.*;
import org.usfirst.frc.team2928.subsystems.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * Robot for 2017.
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
    public static CommandGroup driveAuto;
    public static CommandGroup midAuto;
    public static CommandGroup leftAuto;
    public static CommandGroup rightAuto;
    //TODO: add to these command groups
    // to make the robot do anything during auto.
    public static SendableChooser autoSelector;
    @Override
    public void robotInit() {
        drivebase = new Drivebase();
        //gearmanipulator = new GearManipulator();
        visiontracking = new VisionTracking();
        oi = new OperatorInterface();
        driveAuto = new CommandGroup();
        driveAuto.addSequential(new AutoDriveCommand());
        midAuto = new CommandGroup();
        midAuto.addSequential(new AutoDriveCommand());
        midAuto.addSequential(new VisionDriveCommand());
        midAuto.addSequential(new OpenGearManipulator());
        leftAuto = new CommandGroup();
        leftAuto.addSequential(new AutoDriveCommand());
        leftAuto.addSequential(new RotateCommand(45));
        leftAuto.addSequential(new AutoDriveCommand());
        leftAuto.addSequential(new VisionDriveCommand());
        leftAuto.addSequential(new OpenGearManipulator());
        rightAuto = new CommandGroup();
        rightAuto.addSequential(new AutoDriveCommand());
        rightAuto.addSequential(new RotateCommand(-45));
        rightAuto.addSequential(new AutoDriveCommand());
        rightAuto.addSequential(new VisionDriveCommand());
        rightAuto.addSequential(new OpenGearManipulator());
        //ropeclimber = new RopeClimber();
        //shooter = new Shooter();
        //shifter = new Shifter();
        //intake = new Intake();
        autoSelector = new SendableChooser();
        autoSelector.addDefault("Drive foward", driveAuto);
        autoSelector.addObject("Middle Gear Autonomous",midAuto);
        autoSelector.addObject("Left Gear Autonomous", leftAuto);
        autoSelector.addObject("Right Gear Autonomous", rightAuto);
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
        Scheduler.getInstance().removeAll();
        Command autoCommand = (Command) autoSelector.getSelected();
        autoCommand.start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
}
