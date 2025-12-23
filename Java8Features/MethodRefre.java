package Java8Features;
import java.util.*;
import java.util.stream.Collectors;
public class MethodRefre {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("shyam","kundan","ram");
        list.forEach(System.out::println);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(24);
      
        List<String> list3 = Arrays.asList("A","B","c");
       List<MobilePhone> list4= list3.stream().map(MobilePhone::new).collect(Collectors.toList());
        list4.forEach(x -> System.out.println(x.msg));
    }

}

class MobilePhone{
    String msg ;
    public MobilePhone(String msg){
         this.msg = msg;
    }
}
