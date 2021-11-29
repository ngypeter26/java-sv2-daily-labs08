package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequenceKristof {
    private List<Integer> numbers ;

    public NumberSequenceKristof(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // különbözőnek kell lennie a típus sorrendeknek: vagy a típisok, vagy sorrendek
    public NumberSequenceKristof(int count, int minVal, int maxVal) {
        numbers = new ArrayList<>();

        for (int i = 0; i< count; i++){
            Random random = new Random();
            int rn = random.nextInt(minVal,maxVal);
            numbers.add(rn);
        }
    }
    public NumberSequenceKristof(String a, String b ){
        System.out.println("first");
    }
    public NumberSequenceKristof(String a, String... b ){
        System.out.println("second");
    }
    public NumberSequenceKristof(Integer a ){
        System.out.println("first");
    }

    public NumberSequenceKristof(long a){
        System.out.println("second");
    }

    public List<Integer> closeToAverage(int dx){
        List<Integer> result = new ArrayList<>();
        double average = calculateAverage();
        for (int i : numbers){
            if (Math.abs(average-i)<dx){
                result.add(i);
            }
        }
        return result;
    }

    public double calculateAverage(){
        double sum = 0;
        for (int i : numbers){
            sum += i;
        }
        return sum/numbers.size();
    }

    public static void main(String[] args) {
        new NumberSequenceKristof(1L);
        new NumberSequenceKristof(1);  // a long nagyobb, ezért ezt találja meg
    }


}
