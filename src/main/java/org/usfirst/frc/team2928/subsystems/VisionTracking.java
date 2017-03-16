package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.commands.VisionDebug;

public class VisionTracking extends Subsystem{
    private final NetworkTable visionTable;
    private final int FIELD_OF_VIEW_MULTIPLIER;

    private double visionLeft = 0;
    private double visionRight = 0;

    public VisionTracking(){
        visionTable = NetworkTable.getTable("VisionControl");

        FIELD_OF_VIEW_MULTIPLIER = 1;
    }
    public boolean getLockedLeft(){
        return visionTable.getBoolean("targetLockedLeft", false);
    }
    public boolean getLockedRight(){
        return visionTable.getBoolean("targetLockedRight", false);
    }
    public double getVisionLeft(){return visionTable.getNumber("detectedValueLeft",0);}
    public double getVisionRight(){return visionTable.getNumber("detectedValueRight",0);}
    public double getPos(){
        visionLeft = visionTable.getNumber("detectedValueLeft", 0);
        visionRight = visionTable.getNumber("detectedValueRight", 0);
        SmartDashboard.putNumber("Vision Left Data", visionLeft);
        SmartDashboard.putNumber("Vision Right Data", visionRight);
       return (visionLeft + visionRight)/2;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new VisionDebug());
    }
}
