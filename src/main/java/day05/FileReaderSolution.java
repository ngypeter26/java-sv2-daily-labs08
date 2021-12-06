package day05;


import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderSolution {
    public static void main(String[] args) {
        String fileName = "src/main/resources/weather.dat";
        System.out.println(new FileReaderSolution().findSmallestTemperatureSpread(fileName));

        String fileNameFootball = "src/main/resources/football.dat";
        System.out.println(new FileReaderSolution().findSmallestDifference(fileNameFootball));

    }

    public String findSmallestDifference(String fileName){
            List<String> lines = readFiles(fileName);
            List<Integer> excpetion = Arrays.asList(0,18,lines.size()-1);
            int lineNumber = findMinIndex( lines, excpetion,42,47,50,55);
            return lines.get(lineNumber).substring(6,20).trim();
    }
    public int findSmallestTemperatureSpread(String fileName){
            List<String> lines = readFiles(fileName);
            List<Integer> excpetion = Arrays.asList(0,1,lines.size()-1);
            int lineNumber = findMinIndex( lines, excpetion,6,8,12,14);
            return getInteger(lines,lineNumber,2,4);
    }

    private List<String> readFiles(String fileName){
        try {
            return Files.readAllLines( Paths.get(fileName));
        }catch(IOException ioe){
            throw new IllegalStateException("nincs ilyen file", ioe);
        }
    }

    private int findMinIndex(List<String> lines,List<Integer> exception,int maxIndex1,int maxIndex2,int minIndex1,int minIndex2){
        int minSpread = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i<lines.size();i++){
            if (exception.contains(i)){continue;}
            int spread =getSpread(lines,i, maxIndex1, maxIndex2, minIndex1, minIndex2);
            if (spread <minSpread){
                minSpread = spread;
                minIndex =  i;
            }
        }
        return minIndex;
    }

    private int getSpread(List<String> lines,int lineIndex, int maxIndex1,int maxIndex2,int minIndex1,int minIndex2){
        int max = getInteger(lines,lineIndex,maxIndex1,maxIndex2);
        int min = getInteger(lines,lineIndex,minIndex1,minIndex2);
        return  Math.abs(max-min);
    }

    private int getInteger(List<String> lines,int lineIndex, int index1,int index2){
        return  Integer.parseInt(lines.get(lineIndex).substring(index1,index2).trim());
    }
}
