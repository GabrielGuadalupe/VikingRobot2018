package org.usfirst.frc.team2928;

public class Conversions {
    public static double FeetToTicks(double feet)
    {
        return feet * RobotConstants.DRIVE_TICKS_PER_ROTATION / RobotConstants.WHEEL_CIRCUMFERENCE_FEET;
    }

    public static double TicksToFeet(double ticks)
    {
        return ticks * RobotConstants.WHEEL_CIRCUMFERENCE_FEET / RobotConstants.DRIVE_TICKS_PER_ROTATION;
    }

    public static double FeetToMeters(double feet)
    {
        return 0.3048 * feet;
    }

    public static double MetersToFeet(double meters)
    {
        return meters / 0.3048;
    }
}