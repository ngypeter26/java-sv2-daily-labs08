package day06;


import java.util.Arrays;
import java.util.List;

public class TeamsFileReader extends AbstractFileReader{
    @Override
    public String getFileName() {
        return "football.dat";
    }

    @Override
    public List<Integer> getFilteredPositions() {
        return Arrays.asList(0, 18);
    }

    @Override
    public Position getNamePosition() {
        return new Position(6, 20);
    }

    @Override
    public Position getValue1Position() {
        return new Position(42, 47);
    }

    @Override
    public Position getValue2Position() {
        return new Position(50, 55);
    }
}
