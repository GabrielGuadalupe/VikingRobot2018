package org.usfirst.frc.team2928.Command.Arm;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2928.Robot;
import org.usfirst.frc.team2928.Subsystem.Arm.Climber;

public class RunClimber extends Command {

    private double power;
    public RunClimber(double power) {
        requires(Robot.arm.climber);
        this.power = power;
    }

    @Override
    public void initialize() {
        if (power < 0.5)
        //Robot.arm.climber.setRatchet(Climber.ClimberState.FREE);
        Robot.arm.climber.runClimber(power);
    }


    public void end() {
        Robot.arm.climber.runClimber(0);
        //Robot.arm.climber.setRatchet(Climber.ClimberState.RATCHETED);
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}
