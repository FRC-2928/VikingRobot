package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.team2928.commands.VisionDebug;

/**
 * Created by Max on 1/29/2017.
 */
public class VisionTracking extends Subsystem{
    private final NetworkTable visionTable;

    public VisionTracking(){
        visionTable = NetworkTable.getTable("VisionControl");
    }
    public boolean getLocked(){
        return visionTable.getBoolean("targetLocked",false);
    }
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new VisionDebug());
    }
}
