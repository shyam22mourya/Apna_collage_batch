package Java8Features;

import java.util.*;
import java.util.stream.Stream;;

public class Streams {
    public static void main(String[] args) {

        // // comman exampel
        // List<Integer> list = Arrays.asList(12,34,45,23,56,78);
        // System.out.println(list.stream().filter(x-> x%2==0).toList());

        // String[] str = {"ankit","anita","ram","shyam"};
        // Stream <String> s = Stream.of(str);
        // s.forEach(x -> System.out.println(x));
        // Stream<Integer> stream = Stream.of(12,34,45,23,56,78);
        // stream.forEach(x -> System.out.println(x));

        // They all lazy , meaning they don't execute until a terminal operation is
        // invoked on the stream pipeline, such as forEach, collect, or reduce.

        // 1. Filter
        List<String> list = Arrays.asList("shyam", "gopal", "durga" ,"virendra" ,"shyam");
        Stream<String> stream = list.stream().filter(x -> x.startsWith("s"));
        Long ans = stream.count();
        // System.out.println(ans);


        //  2.map
        Stream <String> stmap = list.stream().map(String::toUpperCase);
        // System.out.println(stmap.toList());


        //3.sorted 
        // System.out.println(list.stream().sorted().toList());
        // System.out.println(list.stream().sorted((a, b)-> a.length()-b.length()).toList());

        //4.distinct
         System.out.println(list.stream().filter(x -> x.startsWith("s")).distinct().count());

         //5.limit
        //  System.out.println(Stream.iterate(1, x -> x+1).limit(100).count());
        
        //  6 skip 
        //  System.out.println(Stream.iterate('a', x -> +).skip(10).limit(100).toList());


        System.out.println(
            Stream.iterate('a', x -> (char)(x + 1)) // next character
                  .limit(26)                       // 26 letters
                  .toList()
        );
    



         // 7 peek
         // Perforem an action on each element is it is consumed 
        // System.out.println(Stream.iterate(1, x -> x+1).skip(10).limit(100).peek(System.out::print).count()); 

        // 8 FlatMap 
        List<List<String >> listofList = Arrays.asList(
            Arrays.asList("apple","banana"),
            Arrays.asList("orange","kiwi"),
            Arrays.asList("pear","grape")
        );
        // System.out.println(listofList.get(1).get(1));
        // System.out.println(listofList.stream().flatMap(x -> x.stream().map(String::toUpperCase)).toList());

        List<String> sentences= Arrays.asList(
            "Hello world",
            "Java stream are powerful",
            "flatMap is useful"
        );

     System.out.println(
        sentences.
        stream().
        flatMap( 
              sentence -> 
              Arrays.stream(sentence.split(" ")).map(String::toUpperCase)).toList());
    }
}
