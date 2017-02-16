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
    public boolean getLockedLeft(){
        return visionTable.getBoolean("targetLockedLeft", false);
    }

    public boolean getLockedRight(){
        return visionTable.getBoolean("targetLockedRight", false);
    }

    public double getPos(){
        return FIELD_OF_VIEW_MULTIPLIER * (visionTable.getNumber("detectedValueLeft", 0) + (visionTable.getNumber("detectedValueRight", 0) / ((this.getLockedLeft() ? 1 : 0) + (this.getLockedRight() ? 1 : 0))));
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new VisionDebug());
    }
}
