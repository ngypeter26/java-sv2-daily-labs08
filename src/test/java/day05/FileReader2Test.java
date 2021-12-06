package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReader2Test {

    @Test
    void testTemperature(){
        String fileName = "src/main/resources/weather.dat";
        int actual = new FileReader2().findSmallestTemperatureSpread(fileName);
        int expected = 14;

        assertEquals(expected,actual);
    }

    @Test
    void testFootball(){
        String fileName ="src/main/resources/football.dat";
        String actual = new FileReader2().findSmallestDifference(fileName);
        String expected = "Aston_Villa";

        assertEquals(expected,actual);
    }
}
