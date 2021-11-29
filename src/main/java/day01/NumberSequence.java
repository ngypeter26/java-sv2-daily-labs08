package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {

    private List<Integer> numbers ;

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSequence(int a, int b, int c) {
        numbers = new ArrayList<>();

        for (int i = 0; i< a; i++){
            Random random = new Random();
            int rn = random.nextInt(b,c);
            numbers.add(rn);
        }
    }

    public List<Integer> closeToAverage(int dx){
        List<Integer> output = new ArrayList<>();
        int average = calculateAverage();
        for (int i : numbers){
            if (Math.abs(average-i)<dx){
                output.add(i);
            }
        }
        return output;
    }

    public int calculateAverage(){
        int sum = 0;
        for (int i : numbers){
            sum += i;
        }
        return sum/numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
