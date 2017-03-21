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
    private static final int MAX_FIELD_OF_VIEW = 30;

    private static final int TICS_PER_REVOLUTION = 1024;

    private final PigeonImu gyro = new PigeonImu(new CANTalon(6));

    private final CANTalon left;
    private final CANTalon leftSlave;
    private final CANTalon right;
    private final CANTalon rightSlave;

    private double numberOfRevolutions;
    private RobotDrive robotDrive;

    public Drivebase() {
        super();

        System.out.println("Netconsole test");
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
        left.setPID(0.03, 0, 0, 0, 0, 1, 0);
        right.setPID(0.03, 0, 0, 0, 0, 1, 0);

        left.configNominalOutputVoltage(+0, -0);
        right.configPeakOutputVoltage(+12, -12);
        left.setProfile(0);
        right.setProfile(0);

        robotDrive = new RobotDrive(left, right);
    }

    public void drive(double move, double rotate) {
        //Wires are stupid, drive things are backwards
        robotDrive.arcadeDrive(rotate, move);
    }

    public void rotate(double angularVelocity) {
        drive(0, -angularVelocity);
    }

    /*
        Three cases: above target, below target, and completely off target
        -networkTables value: Turn right
        +networkTables value: Turn left
        -1,1 Rotate the robot until the input is <1 or >-1
        An input of about .999 is MAX_FIELD_OF_VIEW degrees left of the target
        -.999 is MAX_FIELD_OF_VIEW degrees right of the target
        Things to code:
        A method to convert to degrees
        Gyro PID that takes in the degrees as the current input
        A method that turns right until the input is > -1 or left in the opposite case
     */
    private boolean inRange() {
        if ((Robot.visiontracking.getPos() < MAX_FIELD_OF_VIEW) && (Robot.visiontracking.getPos() > -MAX_FIELD_OF_VIEW)) {
            return true;

        } else {
            return false;
        }
    }

    public boolean onTarget() {
        if ((Robot.visiontracking.getPos() < .1) && ((Robot.visiontracking.getPos() > -.1))) {
            return true;
        } else {
            return false;
        }
    }

    public void visionDrive(double angularVelocity) {
        if (inRange()) {
            robotDrive.arcadeDrive(angularVelocity, 0);
            if (onTarget()) {
                robotDrive.arcadeDrive(0, 0);
            }
        } else {
            if (Robot.visiontracking.getPos() == MAX_FIELD_OF_VIEW) {
                do {
                    robotDrive.arcadeDrive(-.7, 0);
                } while (Robot.visiontracking.getPos() == MAX_FIELD_OF_VIEW);
            } else if (Robot.visiontracking.getPos() == -MAX_FIELD_OF_VIEW) {
                do {
                    robotDrive.arcadeDrive(.7, 0);
                } while (Robot.visiontracking.getPos() == -MAX_FIELD_OF_VIEW);
            }
        }
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

    public double setSetpoint(double distanceInInches) {
        numberOfRevolutions = distanceInInches / (2 * Math.PI * 2.0);
        return numberOfRevolutions;
    }

    public void driveDistance(final double revolutions) {
        double tics = revolutions * TICS_PER_REVOLUTION;
        left.set(tics);
        right.set(tics);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }

    public void setDefaultMode()
    {
        left.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        right.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    }

    public void setDistanceMode()
    {
        left.changeControlMode(CANTalon.TalonControlMode.Position);
        right.changeControlMode(CANTalon.TalonControlMode.Position);

    }

    public boolean isOnPoint()
    {
        return Math.abs(left.getClosedLoopError()) < .4 && Math.abs(right.getClosedLoopError()) < .4;
    }

    public void initPosition()
    {
        left.setPosition(0);
        right.setPosition(0);
    }
}

