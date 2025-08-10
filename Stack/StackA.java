package Stack;
import java.util.* ; 
public class StackA { 
  //Q1.  REVERSE A STRING USING   A STACK ; 
   public static String  reverseString ( String str){
       
    Stack<Character>s = new Stack<>() ; 
    StringBuilder res = new StringBuilder() ; 
       int ind = 0 ; 
        while ( ind<str.length()) {
            s.push( str.charAt(ind)) ; 
            ind++ ; 
        }
      while (!s.isEmpty()) {
        char curr = s.pop() ; 
        res.append(curr) ; 
      } 
       return res.toString() ; 
   }
   /* String str = "shyam" ; 
        String ans =  reverseString(str) ; 
         System.out.println(ans); */


   // 2.  PUSH AT THE BOTTOM OF THE STACK
      public static  void  pushinBotten(  Stack<Integer>s ,  int data){
        // base case 
        if(s.isEmpty()){
             s.push(data) ; 
             return   ; 
        } 
        // recurtion 
       int top =    s.pop() ; 
         pushinBotten(s, data);
         s.push(top);
      }


    //   Q3 reverse Stack 
            public static void  reversStack(  Stack<Integer> s ){
                // base case  
                 if (s.isEmpty()) {     
                    return  ; 
                 }
                 int temp =   s.pop() ; 
                 reversStack(s);
                 pushinBotten(s, temp);
            }

            public static void printstack(  Stack<Integer> s){ 
                 while (!s.isEmpty()) {
                    System.out.println(s.pop());
                 }
            }
         
         
            //    Q 4 Stock spam ;
           public static void  stockspame( int [] stock ,  int stam[]){ 
             Stack<Integer> s = new Stack<>() ; 
                    stam[0] = 1 ; 
                    s.push(0) ; 
                     for ( int i =1 ; i<stock.length ; i++){
                        int currprice = stock[i] ; 
                        while ( !s.isEmpty() && currprice>stock[s.peek()]) {
                          s.pop() ; 
                        }
                         if (s.isEmpty()) {
                          stam[i] = i+1 ; 
                         }else{
                            int prevHigh  = s.peek() ; 
                            stam[i]= i-prevHigh ; 
                         }
                         s.push(i) ; 
                     } 
                     /*int stocks[] = { 100 , 80 ,60 , 70,60, 85 , 100} ; 
         int  spam [] = new int[stocks.length] ; 
          stockspame( stocks , spam) ; 
           for(  int i = 0 ; i<spam.length ; i++){
             System.out.println(spam[i]+" ");
           } */   
            }
         
         
            // Q5 Next greter value 
     public static void nextGreatetValue( int arr[] , int next[] ){
         Stack<Integer> s = new Stack<>() ; 
        for( int i =  arr.length-1 ; i>= 0 ; i--){
             while (!s.empty()&&  arr[s.peek()]<= arr[i]) {
              s.pop() ; 
             } 
              if (s.isEmpty()) {
                next[i] = -1 ; 
              }else{
                 next[i] = arr[s.peek() ];
              }
            s.push(i) ; 
        }
        /* int arr[] = { 6,8,0,1,3} ; 
         int next[] = new int [arr.length] ; 
         nextGreatetValue(arr, next);
      for( int i = 0  ; i<next.length ;i++){
          System.out.print(next[i]+" ");
      }  */
     }

           
     // Q6 vailad parentheses  
        public static boolean validparentheses( String str){ 
           Stack<Character> s = new Stack<>() ; 
            for( int i = 0 ;i< str.length() ;i++){
               char ch = str.charAt(i) ; 
                if (ch == '(' || ch == '{' || ch == '[') {
                  // step 1  Opening 
                   s.push(ch) ; 
                } else{
                    //  step 2 is closing 
                     if( s.isEmpty()){
                       return  false ; 
                     } 
                          if ((s.peek() =='(' && ch==')') ||
                           (s.peek()=='[' && ch == ']')||
                            (s.peek()=='{'&& ch=='}'))   {
                           s.pop() ; 
                            }else {
                           return false ; 
                   }
               }
            }
             if (s.isEmpty()) {
              return true ; 
             }else{
              return false ; 
             }
        }
    
     // Q7  Find if an expression has duplicate parenthesis or not  ;
      public static boolean duparenthese( String str){
           Stack <Character> sh = new Stack<>() ; 

          for( int i = 0 ; i<str.length() ; i++){
             char ch = str.charAt(i) ;  
             
             // closing 
             if (ch == ')') { 
                int count =  0 ; 
               while (sh.peek() !='(') {
                  sh.pop() ; 
                  count ++ ; 
               }
               if (count< 1) {
                  return true ; // duplicates
               }
             else {
                sh.pop() ; // opening   ; 
             }   }  else {
              // opning , pperator , operands
              sh.push(ch) ; 
            }
          }
          return false ; 
      }
    
      // Max area of herogram ;
        public static void maxArea( int [] arr){
          int maxrea = 0; 
            int nsleft [] = new int[ arr.length] ; 
            int nsright [] = new int[ arr.length] ; 

           //  next small  right ;  
          Stack<Integer> s  = new Stack<>() ; 
         for( int i = arr.length-1 ;  i>=0 ; i--){
             while ( !s.isEmpty() &&  arr[s.peek()] >= arr[i]) {
               s.pop() ; 
             } 
              if (s.isEmpty()) {
                nsright [i] = arr.length ;
              } else {
                nsright [i] = s.peek() ; 
              }
               s.push(i ) ; 
             
         }
           // next small left  
               s  = new Stack<>() ; 
           for( int i = 0  ;  i <arr.length  ; i++){
               while ( !s.isEmpty() &&  arr[s.peek() ]>= arr[i]) {
                 s.pop() ; 
               } 
                if (s.isEmpty()) {
                  nsleft [i] = -1 ;
                } else {
                  nsleft [i] = s.peek() ; 
                }
                 s.push(i) ; 
               
           }
           for( int i = 0 ; i< arr.length ; i++){
            System.out.print( nsright[i]+ " , ");
        }  for( int i = 0 ; i< arr.length ; i++){
          System.out.print( nsleft[i]+ " , ");
      }
           // calculate area  
            for ( int i = 0  ; i<arr.length ; i++){
                 int height = arr[i] ; 
                  int weith = nsright[i]- nsleft[i]-1 ; 
                   int water =  height *weith  ; 
                     maxrea = Math.max(maxrea, water)  ;  
            }

            System.out.println( "Max water is "+ maxrea);
        }
        public static void main(String[] args) {
          int arr [] = { 2,1,5,6,2,3} ; 
           maxArea(arr);
    }
  }