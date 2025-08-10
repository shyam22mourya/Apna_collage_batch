package OPPS;


public class Constructer {
    public static void main(String[] args) {
      // Student st =  new Student() ; 
      // Student st1 =  new Student("dhyam") ; 
      Student st2 =  new Student(24) ; 
      System.out.println(st2.rollno);
       pen pq  = new pen() ; 
         pq.colour= "red"; 
         pq.size = 4 ; 
            pq.marks[0]= 100 ; 
            pq.marks[1]= 100 ; 
            pq.marks[2]= 100 ; 
 
         
             pen pq1 = new pen(pq) ; 
             System.out.println( pq1.colour ) ; 
             pq.marks[1] = 00 ; 
             for ( int i = 0 ; i<= pq.marks.length -1 ; i++){
              System.out.println(pq1.marks[i]);
              }

                      }
}
 class pen  {
        String colour; 
         int size ; 
          int marks[]   = new int[3] ; 

         /// non peramarised constructer ; 
         pen (){
         System.out.println(" Print this first ");
         }

         // peramarised constructer; 
         pen (  int size ){
              this.size = size  ; 
         }
         // copy constructer; 
         // shallow copy constructer ; 
        //  pen ( pen  pq){
        //    this.colour =  pq.colour ;   
        //    this.size  = pq.size ;  
        //    this.marks =pq.marks ;   
        //  }

         //  deep copy constructer ; 
          pen ( pen pq ){
            this.colour =  pq.colour ;   
            this.size  = pq.size ;  
         for ( int i = 0 ; i< 3; i++){
             this.marks[i]= pq.marks[i] ; 
             
         }  
          }

          }

          class Student{
            String name ; 
            int rollno; 

            Student(){
               System.out.println("Student is not good");
            }
            Student ( String name){
               this.name = name ;
            }

            Student ( int roll){
               this.rollno = roll ;
            }
          }