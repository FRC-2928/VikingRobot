package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class OpenGearManipulator extends Command{
    public OpenGearManipulator(){
        super();
        requires(Robot.gearmanipulator);
    }

    protected void initialize(){
        Robot.gearmanipulator.open();
    }
    @Override
    protected boolean isFinished() {
        return true;
    }
}
