package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2928.Robot;
import org.usfirst.frc.team2928.commands.JoystickDrive;

public class Drivebase extends Subsystem {

    private static final int FRONT_LEFT_MOTOR_DEVICE_NUMBER = 0 ;
    private static final int FRONT_RIGHT_MOTOR_DEVICE_NUMBER = 3;
    private static final int BACK_LEFT_MOTOR_DEVICE_NUMBER = 1;
    private static final int BACK_RIGHT_MOTOR_DEVICE_NUMBER = 2;
    private static final int MAX_FIELD_OF_VIEW = 30;
   // private final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
   CANTalon frontLeft = new CANTalon(FRONT_LEFT_MOTOR_DEVICE_NUMBER);
    CANTalon backLeft = new CANTalon(BACK_LEFT_MOTOR_DEVICE_NUMBER);
    CANTalon frontRight = new CANTalon(FRONT_RIGHT_MOTOR_DEVICE_NUMBER);
    CANTalon backRight = new CANTalon(BACK_RIGHT_MOTOR_DEVICE_NUMBER);
    private final RobotDrive robotDrive;

        public Drivebase() {
            super();
          invertDrive();

            robotDrive = new RobotDrive(frontRight,backRight,frontLeft,backLeft);
        }
        public void drive(double move, double rotate) {
           //Wires are stupid, drive things are backwards
            robotDrive.arcadeDrive(move, -rotate);
        }
        public void rotate(double angularVelocity)
        {
            robotDrive.arcadeDrive(angularVelocity,0);
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
        private boolean inRange(){
            if ((Robot.visiontracking.getPos() < MAX_FIELD_OF_VIEW) && (Robot.visiontracking.getPos() > -MAX_FIELD_OF_VIEW)) {
                return true;
            }
            else
            {
                return false;
            }
        }
        //
        public void visionDrive(double angularVelocity){
            if(inRange())
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
        //Resets the robot's gyro
        public void calibrateGyro() {
     //       gyro.calibrate();
       //     gyro.reset();
        }
        //Gets the changed angle from the position where the gyro was last reset.
        public double getGyroAngle(){
           // return gyro.getAngle();
            return 0;
        }

        public double getEncoderVelocity(){ return 1;}

        public void uninvertDrive(){
            frontLeft.setInverted(false);
            backLeft.setInverted(false);
            frontRight.setInverted(false);
            backRight.setInverted(false);
        }
        public void invertDrive(){
            frontLeft.setInverted(true);
            backLeft.setInverted(true);
            frontRight.setInverted(true);
            backRight.setInverted(true);
        }

        @Override
        protected void initDefaultCommand() {
            setDefaultCommand(new JoystickDrive());
        }
}
