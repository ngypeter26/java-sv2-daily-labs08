package day05;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader2 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/weather.dat";
        System.out.println(new FileReader2().findSmallestTemperatureSpread(fileName));

        String fileNameFootball = "src/main/resources/football.dat";
        System.out.println(new FileReader2().findSmallestDifference(fileNameFootball));

    }

    public String findSmallestDifference(String fileName) {
        List<String> lines = readFiles(fileName);
        lines = filterLines(lines, Arrays.asList(0, 18));
        List<DataWithDifference> data = extraData(lines, new Position(6, 20),
                new Position(42, 47), new Position(50, 55));
        return findMin(data).getName() ;
    }

    public int findSmallestTemperatureSpread(String fileName) {
        List<String> lines = readFiles(fileName);
        lines = filterLines(lines, Arrays.asList(0, 1, lines.size() - 1));
        List<DataWithDifference> data = extraData(lines, new Position(2, 4),
                new Position(6, 8), new Position(12, 14));
        return Integer.parseInt(findMin(data).getName() );
    }

    private List<String> readFiles(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException ioe) {
            throw new IllegalStateException("nincs ilyen file", ioe);
        }
    }

    private List<String> filterLines(List<String> lines, List<Integer> filtered) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (!filtered.contains(i)) {
                result.add(lines.get(i));
            }
        }
        return result;
    }

    private List<DataWithDifference> extraData(List<String> lines, Position namePosition, Position value1Position, Position value2Position) {
        List<DataWithDifference> result = new ArrayList<>();

        for (String line : lines) {
            String name = namePosition.getAsString(line);
            int value1 = value1Position.getAsInt(line);
            int value2 = value2Position.getAsInt(line);
            result.add(new DataWithDifference(name, value1, value2));
        }
        return result;
    }

    private DataWithDifference findMin(List<DataWithDifference> data) {
        DataWithDifference minData = null;
        int minSpread = Integer.MAX_VALUE;
        for (DataWithDifference d : data) {
            if (d.getDifference() < minSpread) {
                minSpread = d.getDifference();
                minData = d;
            }
        }
        return minData;
    }
}
