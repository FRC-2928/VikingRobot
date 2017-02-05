package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class CloseGearManipulator extends Command{

    public CloseGearManipulator(){
        super();
        requires(Robot.gearmanipulator);
    }
    protected void initialize(){
        Robot.gearmanipulator.close();
    }
    @Override
    protected boolean isFinished() {
        return true;
    }
}
