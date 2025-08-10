package OPPS;

public class Interface {
    public static void main(String[] args) {
         Queen  wh = new Queen() ; 
         
        wh.moves();
        
    }
} 
 interface ChessPlayer {
     void moves () ; 
 }
 class Queen implements ChessPlayer  {
      public void moves (){
         System.out.println( " up  , down , left , right , diagomal , (in all 4 dims )");
      }
 }
class King implements ChessPlayer {
      public  void  moves (){
        System.out.println( " up  , down , left , right , diagomal , (in all 4 dims )");
         
      }
}

class Rook implements ChessPlayer {
     public void moves(){
        System.out.println(" up , down , left , right  (In all 4 dims  )");
     }
}