package day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class NumberSequenceTest {

    @Test
    void testConstructor(){
        List<Integer> input =Arrays.asList(1,2,3,6,7);

        NumberSequence ns1 = new NumberSequence(input);
        System.out.println(ns1.getNumbers());

        NumberSequence ns2 = new NumberSequence(4,1,10);
        System.out.println(ns2.getNumbers());
    }

}
