package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Created by Viking Robotics on 2/6/2017.
 */
public class AutoDrivebase extends Subsystem {

    private static final int FRONT_LEFT_MOTOR_DEVICE_NUMBER = 14 ;
    private static final int FRONT_RIGHT_MOTOR_DEVICE_NUMBER = 1;
    private static final int BACK_LEFT_MOTOR_DEVICE_NUMBER = 15;
    private static final int BACK_RIGHT_MOTOR_DEVICE_NUMBER = 2;
    private static  double NUMBER_OF_REOVLUTIONS = 0;
    private CANTalon frontLeft = new CANTalon(FRONT_LEFT_MOTOR_DEVICE_NUMBER);
    private CANTalon backLeft = new CANTalon(BACK_LEFT_MOTOR_DEVICE_NUMBER);
    private CANTalon frontRight = new CANTalon(FRONT_RIGHT_MOTOR_DEVICE_NUMBER);
    private CANTalon backRight = new CANTalon(BACK_RIGHT_MOTOR_DEVICE_NUMBER);

    public AutoDrivebase(double distanceInInches){

        frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        frontLeft.setInverted(true);
        backLeft.setInverted(true);
        frontRight.setInverted(true);
        backRight.setInverted(true);
        backLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
        backRight.changeControlMode(CANTalon.TalonControlMode.Follower);
        frontLeft.changeControlMode(CANTalon.TalonControlMode.Position);
        frontRight.changeControlMode(CANTalon.TalonControlMode.Position);
        frontLeft.setP(1);
        frontLeft.setI(0);
        frontLeft.setD(0);
        frontRight.setP(1);
        frontRight.setI(0);
        frontRight.setD(0);
        backLeft.set(FRONT_LEFT_MOTOR_DEVICE_NUMBER);
        backRight.set(FRONT_RIGHT_MOTOR_DEVICE_NUMBER);
        frontLeft.set(0);
        frontRight.set(0);
        frontLeft.configEncoderCodesPerRev(360);
        frontRight.configEncoderCodesPerRev(360);
        NUMBER_OF_REOVLUTIONS = distanceInInches/(Math.PI * 6.0);

    }
    public void setSetpoint(){
        frontLeft.set(NUMBER_OF_REOVLUTIONS);
        frontRight.set(NUMBER_OF_REOVLUTIONS);
    }
    public CANTalon getLeftTalon()
    {
        return frontLeft;
    }
    public CANTalon getRightTalon()
    {
        return frontRight;
    }
    @Override
    protected void initDefaultCommand() {

    }
}
