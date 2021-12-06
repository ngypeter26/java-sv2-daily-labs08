package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderSolutionTest {

    @Test
    void testTemperature(){
        String fileName = "src/main/resources/weather.dat";
        int actual = new FileReaderSolution().findSmallestTemperatureSpread(fileName);
        int expected = 14;

        assertEquals(expected,actual);
    }

    @Test
    void testFootball(){
        String fileName ="src/main/resources/football.dat";
        String actual = new FileReaderSolution().findSmallestDifference(fileName);
        String expected = "Aston_Villa";

        assertEquals(expected,actual);
    }
}
