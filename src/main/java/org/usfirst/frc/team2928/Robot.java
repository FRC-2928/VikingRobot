package org.usfirst.frc.team2928;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team2928.commands.AutoDriveCommand;
import org.usfirst.frc.team2928.commands.JoystickDrive;
import org.usfirst.frc.team2928.commands.RotateCommand;
import org.usfirst.frc.team2928.commands.VisionDriveCommand;
import org.usfirst.frc.team2928.subsystems.*;

/**
 * Robot for 2017.
 */
public class Robot extends IterativeRobot {

    public static Drivebase drivebase =  new Drivebase();
    public static OperatorInterface oi;
    public static GearManipulator gearmanipulator = new GearManipulator();
    public static VisionTracking visiontracking;
    public static RopeClimber ropeclimber = new RopeClimber();
    public static Shooter  shooter = new Shooter();
    public static Shifter   shifter = new Shifter();
    public static Intake intake = new Intake();
    public static AutoDrivebase autoDrive  = new AutoDrivebase();
    public static CommandGroup driveAuto;
    public static CommandGroup midAuto;
    public static CommandGroup leftAuto;
    public static CommandGroup rightAuto;
    //TODO: add to these command groups to make the robot do anything during auto.
    public static SendableChooser autoSelector;
    public static Compressor   compressor = new Compressor();
    @Override
    public void robotInit() {
        compressor.start();
        driveAuto = new CommandGroup();
        visiontracking = new VisionTracking();
        autoSelector = new SendableChooser();
        autoSelector.addDefault("Drive Forward", driveAuto);
        autoSelector.addObject("Middle Gear Autonomous",midAuto);
        autoSelector.addObject("Left Gear Autonomous", leftAuto);
        autoSelector.addObject("Right Gear Autonomous", rightAuto);
        //created this last for ordering issues
        oi = new OperatorInterface();
    }

    @Override
    public void teleopInit() {

        Scheduler.getInstance().add(new JoystickDrive());
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
       /* Command autoCommand = (Command) autoSelector.getSelected();
        autoCommand.start();*/
       Scheduler.getInstance().add(new RotateCommand(90));
      //  Scheduler.getInstance().add(new VisionDriveCommand());
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
}
