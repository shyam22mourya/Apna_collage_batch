package ARRAYSMENU.Arraylist;

import java.util.ArrayList;

public class BasicArrlist {

    
    public static void main(String[] agrs) {

      
        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
         list.add(9);
        list.add(4);
         list.add(6);
         list.add(7);
        for( int i =  1; i<list.size()  ; i++){
            
                 if (list.get(i)==list.get(i-1)){ 
                     list.remove(i) ; 
                 
            }
        }
           System.out.println(list);   
        //  * // for add some thing ;
        //  * list.add(2);
        //  * list.add(3);
        //  * list.add(4);
        //  * list.add(6);
        //  * list.add(7);
        //  * list.add(0, 99);
        //  * System.out.println(list) ;  O(1) ; 
        //  * out put 2 ,3,4,6,7 
        //  * 
        //  * // for get elemet
        //  * int elemet = list.get(3);
        //  * System.out.println(elemet);
        //  * O(1) ;
        //  * output =  6; 
        //  * // for remove elemet
        //  * list.remove(1);
        //  * System.out.println(list);
        //  * O(n);
        //  * // for set element ;
        //  * list.set( 1, 12) ;
        //  * System.out.println( list);
        //  * O(n);
        //  * 
        //  * // contain element
        //  * System.out.println(list.contains(99));
        //  * O(n);
        //  * 
        //  * // find size of arraylist
        //  * System.out.println(list.size());
        //  * 
        //  * 
        //  * // for print arrray
        //  * O(n);
        //  * for ( int i = 0 ; i < list.size(); i++){
        //  * System.out.print(list.get(i)+" ");
        //  * }
        //  * // print reverse in arrya
        //  * O(n);
        //  * 
        //  * for ( int i = list.size()-1; i>= 0 ; i--){
        //  * System.out.print(list.get(i)+" ");
        //  * }
        //  */
    }
}
