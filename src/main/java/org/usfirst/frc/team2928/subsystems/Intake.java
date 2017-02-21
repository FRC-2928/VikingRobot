package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

    private final int TALON_NUMBER = 9;
    private final Talon talon;

    public Intake() {
        super();
        talon = new Talon(TALON_NUMBER);
    }

    public void activateIntake(){
        talon.set(1);
    }

    public void deactivateIntake(){
        talon.set(0);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
