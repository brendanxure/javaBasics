/*
  Program title:         Unit Converter
  Program Author:        Brendan Obilo
                         100952871
  Date:                  21/05/2024

  Description:           A class for conversion calculations for a program
                         that converts between two units of measurement for height,
                         weight and temperature.
 */

public class Converter {
    // Establish a constant that holds the constant for weight conversion from lb to kg
    final double WEIGHT_CONSTANT = 0.45359237;
    // Establish a constant that holds the constant for length conversion from inch to meters
    final double LENGTH_CONSTANT = 0.0254;
    // Establish a constant that holds the constant for temperature conversion from (°C) to (°F)
    final double TEMPERATURE_CONSTANT_1 = 1.8;
    // Establish a constant that holds the constant for temperature conversion from (°C) to (°F)
    final double TEMPERATURE_CONSTANT_2 = 32;

    // To calculate the length conversion based on the parameter passed in by the main method
    public double length(double parameter) {
        parameter *= LENGTH_CONSTANT;
        return parameter;
    }

    // To calculate the weight conversion based on the parameter passed in by the main method
    public double weight(double paramter){
        paramter *= WEIGHT_CONSTANT;
        return paramter;
    }

    // To calculate the temperature conversion based on the parameter passed in by the main method
    public double temperature(double parameter){
        parameter = (parameter * TEMPERATURE_CONSTANT_1) + TEMPERATURE_CONSTANT_2;
        return parameter;
    }
}
