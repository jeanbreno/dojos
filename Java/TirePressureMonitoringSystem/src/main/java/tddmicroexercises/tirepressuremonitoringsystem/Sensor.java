package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.*;

public class Sensor implements ISensor {
    private static final double OFFSET = 16;

    public static double getOFFSET() {
        return OFFSET;
    }

    public double popNextPressurePsiValue() {
        double pressureTelemetryValue;
        pressureTelemetryValue = samplePressure( );

        return OFFSET + pressureTelemetryValue;
    }

    private static double samplePressure() {
        Random basicRandomNumbersGenerator = new Random();
        double pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
        return pressureTelemetryValue;
    }
}
