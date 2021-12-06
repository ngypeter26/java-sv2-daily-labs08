package day04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {


    public int findSmallestTemperatureSpread(String fileName){
        Path path = Paths.get(fileName);
        List<String> fileContent =  readFile(path);

        List<Integer> days =  getDay( fileContent);
        List<Integer> spread =  getSpread( fileContent);

        int day = 0;
        int minSpread = Integer.MAX_VALUE;

        for (int i = 0; i<spread.size();i++){
            if(spread.get(i)<minSpread){
                minSpread = spread.get(i);
                day = days.get(i);
            }
        }
        return day;
    }


    public List<Integer> getSpread(List<String> fileContent){
        List<Integer> spread = new ArrayList<>();
        List<Integer> maxVals = getData(fileContent,6,8);
        List<Integer> minVals = getData(fileContent,12,14);

        for(int i = 0; i<maxVals.size();i++){
            spread.add(maxVals.get(i)-minVals.get(i));
        }
        return spread;
    }

    public List<Integer> getDay(List<String> fileContent){
        return getData(fileContent,2,5);
    }

    public List<Integer> getData(List<String> fileContent,int start, int end){
        List<Integer> data = new ArrayList<>();

        for(int i = 2; i<fileContent.size()-1;i++){
            data.add(Integer.parseInt(fileContent.get(i).substring(start,end).trim()));
        }
        return data;
    }

    public List<String> readFile(Path path){
        try {
            return Files.readAllLines(path);
        }catch(IOException ioe){
            throw new IllegalStateException("nincs ilyen file", ioe);
        }
    }

    public static void main(String[] args) {
        String fileName = "src/main/resources/weather.dat";
        System.out.println(new FileReader().findSmallestTemperatureSpread(fileName));
    }
}
