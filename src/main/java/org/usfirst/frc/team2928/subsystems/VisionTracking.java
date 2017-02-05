package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.team2928.commands.VisionDebug;

public class VisionTracking extends Subsystem{
    private final NetworkTable visionTable;
    private final int FIELD_OF_VIEW_MULTIPLIER;

    public VisionTracking(){
        visionTable = NetworkTable.getTable("VisionControl");
        FIELD_OF_VIEW_MULTIPLIER = 30;
    }
    public boolean getLocked(){
        return visionTable.getBoolean("targetLocked",false);
    }

    public double getPos(){
        return FIELD_OF_VIEW_MULTIPLIER * visionTable.getNumber("detectedValue", 0);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new VisionDebug());
    }
}
