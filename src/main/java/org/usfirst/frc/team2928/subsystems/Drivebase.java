package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import com.ctre.PigeonImu;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2928.Robot;
import org.usfirst.frc.team2928.commands.JoystickDrive;

public class Drivebase extends Subsystem {

    private static final int FRONT_LEFT_MOTOR_DEVICE_NUMBER = 0;
    private static final int FRONT_RIGHT_MOTOR_DEVICE_NUMBER = 3;
    private static final int BACK_LEFT_MOTOR_DEVICE_NUMBER = 1;
    private static final int BACK_RIGHT_MOTOR_DEVICE_NUMBER = 2;

    private static final int TICS_PER_REVOLUTION = 1024 * 3;

    private final PigeonImu gyro = new PigeonImu(new CANTalon(6));

    private final CANTalon left;
    private final CANTalon leftSlave;
    private final CANTalon right;
    private final CANTalon rightSlave;
    private RobotDrive robotDrive;

    public Drivebase() {
        super();

        left = new CANTalon(FRONT_LEFT_MOTOR_DEVICE_NUMBER);
        leftSlave = new CANTalon(BACK_LEFT_MOTOR_DEVICE_NUMBER);
        leftSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
        leftSlave.set(FRONT_LEFT_MOTOR_DEVICE_NUMBER);

        right = new CANTalon(FRONT_RIGHT_MOTOR_DEVICE_NUMBER);
        rightSlave =  new CANTalon(BACK_RIGHT_MOTOR_DEVICE_NUMBER);
        rightSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
        rightSlave.set(FRONT_RIGHT_MOTOR_DEVICE_NUMBER);

        left.setInverted(true);
        right.setInverted(true);
        leftSlave.setInverted(true);
        rightSlave.setInverted(true);

        left.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        right.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        left.configEncoderCodesPerRev(TICS_PER_REVOLUTION);
        right.configEncoderCodesPerRev(TICS_PER_REVOLUTION);
        left.reverseSensor(true);
        right.reverseSensor(true);

        // PID Stuff
        left.setPID(0.1, 0, 0, 0.025, 0, 1, 0);
        right.setPID(0.1, 0, 0, 0.025, 0, 1, 0);

        left.configNominalOutputVoltage(+0, -0);
        right.configPeakOutputVoltage(+12, -12);
        left.setProfile(0);
        right.setProfile(0);

        robotDrive = new RobotDrive(left, right);
    }

    public void drive(double move, double rotate) {
        //Wires are stupid, drive things are backwards
        robotDrive.arcadeDrive(rotate, move);
        System.out.println("Left output: "+ left.get());
        System.out.println("Right output: "+ right.get());
    }

    public void rotate(double angularVelocity) {
        drive(0, -angularVelocity);
    }

    //Resets the robot's gyro
    public void calibrateGyro() {
        gyro.SetYaw(0);
    }

    //Gets the changed angle from the position where the gyro was last reset.
    public double getGyroAngle() {
        double[] ypr = new double[3];
        gyro.GetYawPitchRoll(ypr);
        return ypr[0];
    }
    public double getPosition()
    {
        return (Math.abs(left.getPosition()) + Math.abs(right.getPosition()))/2;
    }

    public double inchesToEncTics(double distanceInInches) {
        return (distanceInInches / (2 * Math.PI * 2.0)) * TICS_PER_REVOLUTION;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }

    public void setDefaultMode() {
        left.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        right.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        setBrakeMode(false);
    }

    public void setDistanceMode() {
        left.changeControlMode(CANTalon.TalonControlMode.Position);
        right.changeControlMode(CANTalon.TalonControlMode.Position);
        setBrakeMode(true);
    }

    public void setBrakeMode(boolean enabled) {
        left.enableBrakeMode(enabled);
        leftSlave.enableBrakeMode(enabled);
        right.enableBrakeMode(enabled);
        rightSlave.enableBrakeMode(enabled);
    }

    public boolean isOnPoint() {
        System.out.println("Left Error: " + left.getClosedLoopError());
        System.out.println("Left setpoint: " + left.getSetpoint());
        System.out.println("Left position: " + left.getEncPosition());
        return false;
    }

    public void initPosition() {
        left.reset();
        left.setEncPosition(0);
        right.setEncPosition(0);
    }
}

