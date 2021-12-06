package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderSolutionWithFootBall {
    public static void main(String[] args) {
        String fileName = "src/main/resources/weather.dat";
        System.out.println(new FileReaderSolutionWithFootBall().findSmallestTemperatureSpread(fileName));

        String fileNameFootball = "src/main/resources/football.dat";

        System.out.println(new FileReaderSolutionWithFootBall().findSmallestDifference(fileNameFootball));
    }

    private String findSmallestDifference(String fileName){
        try {
            List<String> lines = Files.readAllLines( Paths.get(fileName));
            int minSpread = Integer.MAX_VALUE;
            String minTeam = "";
            for(int i = 1; i<lines.size();i++){
                if (i==18){continue;}
                String team = lines.get(i).substring(6,20).trim();
                int max = Integer.parseInt(lines.get(i).substring(21,26).trim());
                int min = Integer.parseInt(lines.get(i).substring(27,32).trim());
                int spread = max-min;
                if (spread<minSpread){
                    minSpread = spread;
                    minTeam = team;

                }
            }
            return minTeam;
        }catch(IOException ioe){
            throw new IllegalStateException("nincs ilyen file", ioe);
        }
    }

    private int findSmallestTemperatureSpread(String fileName){
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
