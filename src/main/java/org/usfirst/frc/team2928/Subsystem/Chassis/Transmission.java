package org.usfirst.frc.team2928.Subsystem.Chassis;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.RobotConstants;
import org.usfirst.frc.team2928.RobotMap;

import static java.lang.System.currentTimeMillis;
import static org.usfirst.frc.team2928.Subsystem.Chassis.Transmission.GearState.HIGH;
import static org.usfirst.frc.team2928.Subsystem.Chassis.Transmission.GearState.LOW;

public class Transmission extends Subsystem {

    private final Solenoid shiftSolenoidLow;
    private final Solenoid shiftSolenoidHigh;
    private GearState currentState;

    private long lastShift = 0;

    public enum GearState
    {
        HIGH,
        LOW;

        public GearState toggle()
        {
            return this.equals(HIGH) ? LOW : HIGH;
        }
    }

    public Transmission()
    {
        shiftSolenoidLow = new Solenoid(RobotMap.SOLENOID_TRANSMISSION_LOW);
        shiftSolenoidHigh = new Solenoid(RobotMap.SOLENOID_TRANSMISSION_HIGH);
        shiftSolenoidLow.set(true);
        shiftSolenoidHigh.set(false);
        currentState = LOW;
    }

    public void shift(GearState state)
    {
        long time = currentTimeMillis();
        if ((time - lastShift) > RobotConstants.SHIFT_DELAY_MS)
        {
            if (state == HIGH)
            {
                shiftSolenoidHigh.set(true);
                shiftSolenoidLow.set(false);
            }
            else
            {
                shiftSolenoidHigh.set(false);
                shiftSolenoidLow.set(true);
            }
            currentState = state;
            lastShift = time;
        }
        SmartDashboard.putString("Gear", state == GearState.LOW ? "Low" : "High");
    }

    public void toggle()
    {
        shift(getGear().toggle());
    }

    public GearState getGear()
    {
        return currentState;
    }

    @Override
    protected void initDefaultCommand() {
    }
}
