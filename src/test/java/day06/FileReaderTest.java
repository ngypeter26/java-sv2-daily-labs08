package day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {
    @Test
    void testTemperature(){
        String actual = new TemperatureFileReader().findSmallestDifferenceName();
        String expected = "14";

        assertEquals(expected,actual);
    }

    @Test
    void testFootball(){
        String actual = new TeamsFileReader().findSmallestDifferenceName();
        String expected = "Aston_Villa";

        assertEquals(expected,actual);
    }
}
