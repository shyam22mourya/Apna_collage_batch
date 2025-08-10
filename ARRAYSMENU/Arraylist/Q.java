package ARRAYSMENU.Arraylist;

import java.util.ArrayList;

public class Q { 
      public static int  Storerainwater( ArrayList<Integer>height){
// This my bruthforce approach ; 
// time complexity  O(n) ; 
        int Max = 0  ;
        for ( int i  = 0 ; i<height.size() ; i++){
            for ( int j = i+1 ; j<height.size() ; j++ ){
                int hit = Math.min(height.get(i), height.get(j))  ; 
                int wid = j-i; 
                 int currwater = hit*wid ; 
                  Max = Math.max(Max, currwater) ; 
            }
         }
         return  Max ;
      }
     
     public static int storerainwater ( ArrayList<Integer>height){

        //   time complexity  = O(n) ; 
         int maxwater = 0 ; 
          int lp = 0 ; 
          int rp = height.size();
          while (lp < rp ) { 

            //   calculate rainwater   
              int heit = Math.min( height.get(lp), height.get(rp)) ; 
              int width = rp-lp  ; 
               int currwater = heit*width; 
                 maxwater = Math.max(maxwater, currwater); 
            // update rainwater ;   
             
             if  (  height.get(lp)< height.get(rp)){
                lp++ ; 
             }else{   // when rp < lp ; 
                 rp --;     
             }

          }
      return maxwater ; 


     }
      public static void main(String[] args) {
         ArrayList<Integer> hight  = new ArrayList<>(); 
         hight.add(1);
         hight.add(8);
         hight.add(6);
         hight.add(2);
         hight.add(5);
         hight.add(4);
         hight.add(8);
         hight.add(3);
         hight.add(7); 
            
        System.out.println(storerainwater(hight));  

     }
}
