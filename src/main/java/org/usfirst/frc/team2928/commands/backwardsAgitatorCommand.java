package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;

public class backwardsAgitatorCommand extends Command {
    public backwardsAgitatorCommand(){
        requires(Robot.shooter);
    }
    @Override public void initialize()
    {
        Robot.shooter.runAgitator(-.75);
    }
    @Override
    public void end() {
        Robot.shooter.stopAgitation();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
