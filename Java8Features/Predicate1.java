package Java8Features;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;

public class Predicate1 {
   public static void main(String[] args) {

      Predicate<Integer> isEven = x -> x%2 == 0 ;

      Predicate <String> isWordStartWithA  = x -> x.toLowerCase().startsWith("a");
      Predicate <String> isWordEndWithA  = x -> x.toLowerCase().endsWith("a");
      Predicate <Integer> greater = (x)-> { return x > 10 ;  }; 
      Predicate <Integer> smallter = x -> x < 20 ;
      // System.out.println(greater.and(smallter).negate().test(25));
      // System.out.println(greater.test(10));
      // System.out.println(isWordStartWithA.test("ankit"));
      // isConsist only 
      // public static void isEven (int x ){ return x %2 == 0 ;  } 
      // System.out.println(isWordStartWithA.and(isWordEndWithA).negate().test("anita"));
      
      Function<Integer , Double > divide = x -> x / 2.0; 
      // System.out.println(divide.apply(20));

      Function<Integer , Integer > dou =  x -> x*2; 
      Function<Integer , Integer> triple = x -> x*3; 
      System.out.println(dou.andThen(triple).apply(3));
      System.out.println(dou.compose(triple).apply(3));

      Function<Integer , Integer> ir =  Function.identity(); 
      //   System.out.println(ir.apply(12));
      
      Consumer <Integer> print =  x -> System.out.println(x);
      print.accept(23);
      Consumer <String > string = x-> System.out.println(x);
      // string.andThen(print).accept(12);
      List<Integer> list = Arrays.asList(12, 23, 43,34);
      
      Consumer<List<Integer> >  printList =   x -> {
         for (int  i : x) {
            System.out.print(i+" ");
         }
      };
      printList.accept(list);

      // Supplier <String> giveHelloWorld
      Supplier<Integer> it  = () -> 24  ;
      System.out.println(it.get());  

      // combine exampel 
      Predicate <Integer> predicate = x -> x%2 == 0 ; 
      Function<Integer , Integer> fucntion =  x -> x*x ; 
      Consumer<Integer > consumer = x -> System.out.println(x);
      Supplier <Integer> supplier = () ->   200 ; 
      supplier.get();
      if(predicate.test(supplier.get())){
         consumer.accept(fucntion.apply(supplier.get()));
      }

      // Bipridicate 
      BiPredicate<String , String > st = (x , y )-> {return x.startsWith("a")&& y.startsWith("m");} ;
      System.out.println(st.test("anand", "alvita")); 

      // BiConsumer
      BiConsumer<Integer,String> biConsumer= (x ,y)->{
         System.out.println(x);
         System.out.println(y);
      };
      biConsumer.accept(12, "shyam");

      BiFunction<Integer, String, Integer> biFunction = (x, y) -> { return (String.valueOf(x) + y).length(); };
       System.out.println("bi : "+biFunction.apply(12, "Shyam"));
      // Call biConsumer with different values
      biConsumer.accept(42, "call him");


      UnaryOperator <Integer> a = x -> 2*x;
            System.out.println(a.apply(12));


       BinaryOperator<Integer > b = (x ,y) -> x+y ;
       System.out.println(b.apply(12, 87));

   }
}