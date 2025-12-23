package Java8Features;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Terminal {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(12, 34, 54, 38);

    // 1 collect data ,and skip
    // System.out.println(list.stream().skip(1).collect(Collectors.toList()));

    // 2 for each
    // list.stream().forEach(x -> System.out.print(x));

    // Q3 . reduce
    long minNums = list.stream().reduce((x, y) -> x > y ? x : y).get();
    // System.out.println(minNums);

    // System.out.println(list.stream().reduce((x , y )-> x+y).get());

    // Q4 limit () , count () ;

    Long data = list.stream().filter(x -> x % 2 == 1).count();
    System.out.println(data);

    List<Integer> tep = Stream.iterate(1, x -> x + 1).skip(10).limit(100).toList();
    // System.out.println(tep);

    // Q 5 any Match , all Match , noneMatch ;
    System.out.println(list.stream().anyMatch(x -> x % 2 == 0));
    System.out.println(list.stream().allMatch(x -> x % 2 == 1));
    System.out.println(list.stream().noneMatch(x -> x % 2 == 1));

    // Q6 Findfirst , findLast , findAny ;
    String[] arr = { "java", "javaScript", "html", "styling Casecading" };
    List<String> list2 = Arrays.asList(arr);
    // System.out.println( list2.stream().findFirst().get());

//Q 7 toArray(); 
 Object []  array = Stream.of(1,2,3,4).toArray(); 
// System.out.println(array);


// Q 8 . min / max 
  System.out.println("max : " + Stream.of(2 ,33 , 69).max((o1 , o2 )-> o1-o2 ));
  System.out.println("min : " + Stream.of(2 ,33 , 69).min(Comparator.naturalOrder()));


  //Q 9 forEachOrdered
   List<Integer> number0 = Arrays.asList(1 ,2 ,3 ,4 ,5,6,7,8,9,10);
   System.out.println("Using forEach with parallel stream");
   number0.parallelStream().forEachOrdered(System.out::println);
    // Example : Filtering ans Collecting Names ;
    List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
    // System.out.println(names.stream().filter(x -> x.length() > 3).toList());
 
   //Example  sorting and Squaring Number 
    List<Integer> numbers = Arrays.asList(5 ,4,9,1,2 );
    // System.out.println(numbers.stream().map( x -> x*x).sorted().toList());
 
    // Summing values 
    //  System.out.println(list.stream().reduce(Integer::sum).get()); 

     // Example : Counting Occurences of a Character 
      String sentence = "Hello world";
      IntStream st = sentence.chars(); 
      // System.out.println(st.filter( x -> x =='l').count()); 


      //Examp 
       Stream<String> stream = names.stream(); 
       stream.forEach(System.out::println);
      // List<String> strea =  stream.map(String::toUpperCase).toList(); 
      // System.out.println(strea);
  }
}
