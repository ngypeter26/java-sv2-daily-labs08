package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderSolution {
    public static void main(String[] args) {
        String fileName = "src/main/resources/weather.dat";
        System.out.println(new FileReaderSolution().findSmallestTemperatureSpread(fileName));
    }
    public int findSmallestTemperatureSpread(String fileName){
        try {
            List<String> lines = Files.readAllLines( Paths.get(fileName));
            int minSpread = 1000;
            int minDay = 0;
            for(int i = 2; i<lines.size()-1;i++){
                int day = Integer.parseInt(lines.get(i).substring(2,4).trim());
                int max = Integer.parseInt(lines.get(i).substring(6,8).trim());
                int min = Integer.parseInt(lines.get(i).substring(12,14).trim());
                int spread = max-min;
                if (spread<minSpread){
                    minSpread = spread;
                    minDay = day;
                }
            }
            return minDay;
        }catch(IOException ioe){
            throw new IllegalStateException("nincs ilyen file", ioe);
        }
    }
}
