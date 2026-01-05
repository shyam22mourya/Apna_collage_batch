package Revision;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueue1 {

    static class Employee implements  Comparable<Employee>{
         int id , salary ;
         String name ;

        public Employee(int i, String shyam, int i1) {
            this.id = i ;
            this.name = shyam ;
            this.salary = i1;
        }

        @Override
        public String toString() {
            return id + " "+ name + " "+salary ;
        }

        @Override
        public int compareTo(Employee o) {
            if(o.salary==this.salary){
                 return o.id -this.id ;
            }
            return  o.salary-this.salary;
        }
    }

    public static  String largestEven(String s) {
        long num = 0;
        for(char c : s.toCharArray()){
            num  = num *10 ;
            num += c-'0' ;
            System.out.println(num);
        }

        while(!(num %2 == 0 )){
            num = num/10 ;
        }
        return num > 0 ? num+"": "" ;
    }
    static void main() {
//        PriorityQueue<Employee> com = new PriorityQueue<>( );
//        com.add(new Employee(1 , "shyam",120000));
//        com.add(new Employee(2 , "ram",12000));
//        com.add(new Employee(3, "rakesh",12000));
//        com.add(new Employee(4 , "piyush",12000));
//        com.add(new Employee(5 , "kundan",120000));
//        while (!com.isEmpty()){
//            System.out.println(com.poll());
//        }

        Heap minHeap = new Heap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(2);
        minHeap.insert(1);
largestEven("2211112112");
//        while (!minHeap.isEmpty()){
//            System.out.println(minHeap.peek());
//            minHeap.poll();
//        }

//        int arr[] = { 12 ,2,3,4,8,1 ,7};
//        minHeap.heapSort(arr , arr.length);
//        for(int i : arr){
//            System.out.print(i+ " ");
//        }


    }


}
class Heap {

     ArrayList<Integer> arr = new ArrayList<>() ;

     // log n
     void  insert(int val){ // step 1 add element then fix head ;

        arr.add(val);

        // fix head
         int child = arr.size()-1 ;
         int parent = (child-1)/2 ;
         while (arr.get(child) > arr.get(parent)){

             int temp = arr.get(child);
             arr.set(child , arr.get(parent));
             arr.set(parent , temp);

             child = parent ;
             parent = (child-1)/2 ;
         }

     }
     int peek (){
          return arr.get(0);
     }

     int poll(){
         int last = arr.size()-1 ;
          // step 1 swap first and last ;
         int temp = arr.get(0);
         arr.set(0 , arr.get(last));
         arr.set(last , temp);

         // remove last
        int data =   arr.remove(last);
         heapify(0);
       return data ;
     }
     boolean isEmpty(){
          return arr.isEmpty();
     }
     void heapify(int i ){

         int left = 2*i+1 ;
         int right = 2*i+2 ;
         int min = i ;

         while (left < arr.size() && arr.get(min) < arr.get(left)){
              min = left ;
         }

         while (right < arr.size() && arr.get(min) < arr.get(right)){
             min = right ;
         }

         if(min != i ){

             int temp = arr.get(i);
             arr.set(i , arr.get(min));
             arr.set(min , temp);

             heapify(min);
         }

     }

     void  heapify(int []arr ,int i , int n ){
         int left = 2*i+1 ;
         int right = 2*i+2;
         int max = i ;

          if(left < n && arr[left] < arr[max]){
               max = left ;
          }
          if(right < n  && arr[right] < arr[max]){
               max = right ;
          }

          if(max != i ){
          int temp = arr[max];
          arr[max]  = arr[i];
          arr[i] = temp ;

          heapify(arr , max , n );
          }
     }
     void heapSort(int arr[] , int n ){

         // convert it to max heap
         for(int i = n/2 ; i>= 0 ; i--){
              heapify(arr ,  i , n );
         }

         // now move largest element to last of and keep doing ;
          for(int i = n-1 ; i>= 0 ; i--){
              int temp = arr[0];
              arr[0]  = arr[i];
              arr[i] = temp ;

              heapify(arr , 0 , i );
          }
     }

}
