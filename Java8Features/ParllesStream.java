package Java8Features;

import java.util.stream.Stream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ParllesStream {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> facList = list.stream().map(ParllesStream::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time takes with stream " + (endTime - startTime) + " ms ");

        startTime = System.currentTimeMillis();
        facList = list.parallelStream().map(ParllesStream::factorial).sequential().toList();
        endTime = System.currentTimeMillis();

        System.out.println(" Time takes with stream " + (endTime - startTime) + " ms ");

    //Cumlative Sum 
     // [1, ,2 ,3 ,4, 5] --> [1, 3,6,10,15]
      List<Integer > numbers = Arrays.asList(1,2,3,4,5);
      AtomicInteger sum = new AtomicInteger(0) ; 
     List<Integer> cumlative  =  numbers.stream().map(sum::addAndGet).toList();
     System.out.println(cumlative);
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
