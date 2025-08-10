package ARRAYSMENU.Arrays ; 
public class Array {

    public static void update (int marks[]){
         for (int i = 0 ; i<marks.length ; i++){
         if ( i == 0 ){ 
                 marks[i] +=5 ; 
             }  


             if (i == 1){
                 marks[i]+=10 ; 
             }  
             else 
            marks[i]+=1 ; 
         }
    }
   public static void main(String[] args) {  
     int marks[]= {23 , 23,23} ;  
     // input / output
  update(marks);
  //print   our marks  
   for (  int i =marks.length-1 ;  i >= 0  ;  i--){
     System.out.print(marks[i]+" ");
   }
   System.out.println();
  
   }
}
