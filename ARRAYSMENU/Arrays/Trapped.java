package ARRAYSMENU.Arrays;

public class Trapped { 
     public static int trappedRainwater( int height[]){
            int h = height.length; 
            int  trappedwater =  0 ; 

          // calculater left max boundary  - array  ;   
            int leftmax  [] =  new int[h] ; 
             leftmax[0 ]  = height[0]  ; 
             for ( int  i = 1  ; i < h ; i++ ){
                 leftmax [i] = Math.max(leftmax[i-1], height[i]); 
             } 

          // calculater right max boundary  - array  ;   
           
             int  rightmax [] = new int[h]  ;  
              rightmax[h-1] = height[h-1] ; 
             for (  int i = h-2 ; i >= 0 ; i--){
                 rightmax [i] = Math.max(rightmax[i+1], height[i]) ;  

             }
            // loop  ;  
             for (   int i = 0;  i < h ; i++){
            // waterlevel = min of left and rain ;  
                int  Waterlavel = Math.min( leftmax[i] ,rightmax[i]) ; 
            // trapped water += waterlaver - hight[i] ; 
               trappedwater += Waterlavel - height[i];
             }
        return trappedwater ;    
         
     }
     public static void main(String[] args) {
        int hight []={4 , 2 , 0,6  ,3, 2 , 5 }; 
        System.out.println(trappedRainwater(hight));
     }
     
}
