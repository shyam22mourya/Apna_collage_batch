package Java8Features;

import java.util.*;
import java.util.stream.*;

public class CollectorsDemo {
    public static void main(String[] args) {

        // 1. Collecting to a list ;
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> a = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        // System.out.println(a);

        // 2 Collecting to a Set
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 4, 5);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        // System.out.println(set);

        // Q3 . Collecting to a Specific Collection
        ArrayDeque<String> collect = names
                .stream()
                .collect(Collectors
                        .toCollection(
                                () -> new ArrayDeque<>()));
        // System.out.println(collect);

        // Q4 Joining Strings
        String concateString = names
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));
        // System.out.println(concateString);

        // Q5 Summring Data
        // Generates Statistical summary (count , sum , min , average , max)
        List<Integer> number = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics stats = number.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("count : " + stats.getCount());
        System.out.println("Sum : " + stats.getSum());
        System.out.println("Min : " + stats.getMin());
        System.out.println("Average : " + stats.getAverage());
        System.out.println("Max : " + stats.getMax());
        System.out.println("class : " + stats.getClass());

        //  6  . Calculating Averages 
        Double average = number.stream().collect(Collectors.averagingInt(x -> x ));
      System.out.println(average);

      // 7  Counting Elements
      Long count = number.stream().collect(Collectors.counting());
    //   System.out.println("Count : "+count);

      // 8 Grouping Elements 
     List<String> words = Arrays.asList("hello" ,"world","java","streams","collections");
    System.out.println(  words.stream().collect(Collectors.groupingBy( String::length))); ; 
    System.out.println(words.stream().collect(Collectors.groupingBy(String::length , Collectors.joining(", "))));
    System.out.println(words.stream().collect(Collectors.groupingBy(String::length , Collectors.counting())));
  TreeMap<Integer ,Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length , TreeMap::new , Collectors.counting()));
//  System.out.println(treeMap);


// 9 . Partitioning Elements 
// Partitions elements into two groups (true and false ) based on a predicate 
//   System.out.println(words.stream().collect(Collectors.partitioningBy( x -> x.length()  > 5 )));


  //10 Mapping  and Collecting 
   // Applies a mapping fucntion before collecting 
   System.out.println( words.stream().collect(Collectors.mapping(String::toUpperCase , Collectors.toList())));

// Exapple 
// Collectng Nmaes by  Length 
    List<String > l1  = Arrays.asList("Anna" , "Bob" , "Alexander", "Brian" ,"Alice" ) ; 
    //  System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));  

     // Countint word Occurrence 
     String sentence = "hello world hello java world";
//    System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy((x -> x),Collectors.counting())));
   
    // Exaple 3 Partition Even and Odd Numbers 
        List<Integer> l2 = Arrays.asList(1,2,3,4,5,6);
        //  System.out.println(l2.stream().collect(Collectors.partitioningBy(x-> x%2== 0 ))); 

        // Exaple 4 : Summing Values in a Map 
        Map<String , Integer > items = new HashMap<>(); 
        items.put("Apple", 10) ;
        items.put("Banana", 30);
        items.put("Orange", 20);

    System.out.println( items.values().stream().collect(Collectors.summingInt(x -> x))) ;

    // Examles 5 : Creating a Map from Stream Elements 
    List<String > l3  = Arrays.asList("Apple" , "Banaana" , "Charry", "Brian" ,"Alice" ) ; 
  System.out.println(l3.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x->x.length())));
     
   // Example 6 
    List<String > word2  = Arrays.asList("apple" , "banana" , "apple", "orange" ,"banana" ,"apple" ) ; 
System.out.println(word2.stream().collect(Collectors.toMap( k -> k , v -> 1 , (x, y) -> x+y ) ));

}
}
