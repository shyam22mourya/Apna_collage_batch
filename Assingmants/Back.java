 package Assingmants ; 
  class Back {
     static String []   keypad = { "" ,"" ,"abc", "def" , "ghi" , "jkl", "mno" , "pqrs" , " tuv" ,"wxyz"} ; 

     //Q1 RAT IN MAZE 
     public static void printboard(int[][] maze) {
        // System.out.println("__________RAT IN MAZE_________");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
      public static void   ratMaze ( int i  ,  int j  , int n , int [][]maze, boolean [][] visited  ,  String str  ){
         // base case
     if ( i< 0|| j< 0 || i>=n || j >= n) {
    return  ; 
 } 
  if( maze [i][j]==0 || visited [i][j]==true ){
     return  ; 
  }
  if ( i == n-1&& j == n-1){
     System.out.println("SOLUTION IS POSIBLE"); 
    //   printboard(maze);
      System.out.println(str);
      return ; 
    
  }
   
         //recurtion
          visited [i][j]= true ; 
           
          ratMaze(i+1, j, n, maze, visited, str+"D");
          ratMaze(i-1, j, n, maze, visited, str+"U");
          ratMaze(i, j-1, n, maze, visited, str+"L");
          ratMaze(i, j+1, n, maze, visited, str+"R"); 
            visited[i][j]= false   ;   // BACKTRACKING 


      }
   
   
      public static void main(String[] args) { 
        //  int maze [][] = {  
        //  { 1,1,1,1},
        //  {0,1,0,1},
        //  {1,1,1,1},
        //  {1,0,1,1} };  
        //  int n = maze.length    ;
        // boolean visited [][] = new boolean [n][n]  ;
        // ratMaze(0, 0, 4, maze , visited ,"") ;   
         
        //    String digit   = "23" ; 
        //       printcom(  digit  , "",  0 ) ;  
               knight( ) ; 
    }  

    //Q 2 print keyboard  key problem 
    // O(4^n) ;  n == digit.length() ; 
      public static   void  printcom (  String digit , String output , int  i ){
        
           // base case  
           if ( i ==  digit.length()){
                 System.out.println( output);
                  return ; 
            }

             for (   char letter : keypad[digit.charAt(i)-'0'].toCharArray()){
                printcom( digit, output+letter, i+1); 
             }
      }   
       

       // Q3 Knight problem  
    //    O(N^8) ;
       static int [] xmove  = { 2 , 1 , -1 , -2 , -2 , -1 ,1, 2} ; 
       static int [] ymove = { 1 , 2 , 2, 1 , -1 , -2, -2, -1} ; 
       static  int N = 8 ; 
       public static boolean knight() {
        int[][] sol = new int[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }

        // we consider the knight is starting from (0, 0)
        sol[0][0] = 0;

        if (!solveutillknight(0, 0, 1, sol)) {
            System.out.println("SOLUTION IS NOT EXIT");
            return false;
        } else {
            printboard(sol);
            return true;
        }
    }

    public static boolean issafe(int x, int y, int move, int[][] maze) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == -1);
    }

    public static boolean solveutillknight(int x, int y, int move, int[][] sol) {
        if (move == N * N ) {
            return true;
        }

        for (int k = 0; k < N; k++) {
            int newx = x + xmove[k];
            int newy = y + ymove[k];
            if (issafe(newx, newy, move, sol)) {
                sol[newx][newy] = move;
                if (solveutillknight(newx, newy, move + 1, sol)) {
                    return true;
                } else {
                    sol[newx][newy] = -1; // this is the backtracking step
                }
            }
        }
        return false;
    }

   
    }
