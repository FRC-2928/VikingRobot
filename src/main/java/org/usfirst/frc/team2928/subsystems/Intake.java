package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

    private final int TALON_NUMBER = 1;
    private final Talon talon;

    public Intake() {
        super();
        talon = new Talon(TALON_NUMBER);
    }

    public void activateIntake(){
        talon.setSpeed(-1);
    }

    public void deactivateIntake(){
        talon.setSpeed(0);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
