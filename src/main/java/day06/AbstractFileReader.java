package day06;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractFileReader {

    public String findSmallestDifferenceName() {
        List<String> lines = readFiles(getFileName());
        lines = filterLines(lines, getFilteredPositions());
        List<DataWithDifference> data = extraData(lines, getNamePosition(),
                getValue1Position(), getValue2Position());
        return findMin(data).getName() ;
    }

    public abstract String getFileName();
    public abstract List<Integer> getFilteredPositions();
    public abstract Position getNamePosition();
    public abstract Position getValue1Position();
    public abstract Position getValue2Position();

    private List<String> readFiles(String fileName) {
        try {
            return Files.readAllLines(Paths.get("src/main/resources/"+fileName));
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
