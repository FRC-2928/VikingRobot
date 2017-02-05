package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team2928.Robot;
import org.usfirst.frc.team2928.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The drive system on the test platform consists of one motor.
 */
public class Drivebase extends Subsystem {

    private static final int FRONT_LEFT_MOTOR_DEVICE_NUMBER = 14;
    private static final int FRONT_RIGHT_MOTOR_DEVICE_NUMBER = 15;
    private static final int BACK_LEFT_MOTOR_DEVICE_NUMBER = 1;
    private static final int BACK_RIGHT_MOTOR_DEVICE_NUMBER = 2;
    private static final int MAX_FIELD_OF_VIEW = 30;
    private final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    private final RobotDrive robotDrive;

    public Drivebase() {
        super();
        robotDrive = new RobotDrive(FRONT_LEFT_MOTOR_DEVICE_NUMBER, FRONT_RIGHT_MOTOR_DEVICE_NUMBER, BACK_LEFT_MOTOR_DEVICE_NUMBER, BACK_RIGHT_MOTOR_DEVICE_NUMBER);
    }
    public void drive(double x, double y) {
        robotDrive.arcadeDrive(x,y);
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
    public boolean inRange(){
        if ((Robot.visiontracking.getPos() < MAX_FIELD_OF_VIEW) && (Robot.visiontracking.getPos() > -MAX_FIELD_OF_VIEW)) {
            return true;

        }
        else
        {
            return false;
        }
    }
    public void visionDrive(double angularVelocity){
        if(inRange() == true)
        {
           robotDrive.arcadeDrive(angularVelocity,0);
        }
        else{
            if (Robot.visiontracking.getPos() ==MAX_FIELD_OF_VIEW)
            {
                do{
                    robotDrive.arcadeDrive(-.7,0);
                }while(Robot.visiontracking.getPos()==MAX_FIELD_OF_VIEW);
            }
            else if(Robot.visiontracking.getPos()==-MAX_FIELD_OF_VIEW)
            {
                do{
                    robotDrive.arcadeDrive(.7,0);
                }while(Robot.visiontracking.getPos()==-MAX_FIELD_OF_VIEW);
            }
        }
    }

    public void calibrateGyro() {
        gyro.calibrate();
        gyro.reset();
    }

    public double getGyroAngle(){
        return gyro.getAngle();
    }

    public double getEncoderVelocity(){ return new CANTalon(FRONT_LEFT_MOTOR_DEVICE_NUMBER).getEncVelocity();}

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
}
