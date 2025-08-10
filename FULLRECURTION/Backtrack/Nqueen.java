package FULLRECURTION.Backtrack;
public class Nqueen {
     static  int count = 0 ; 
    public static boolean issafe(char board[][], int row, int col) {

        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right up
        for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length-1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

    public static void printboard(char board[][]) {
        System.out.println("__________chess board_________");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
  // this is another Question for nQueen  print only 1 solution ; 
    public static boolean nqueenonly(char board[][], int row) {
        // base case
        if (row == board.length) {
      //      printboard(board);
            count ++ ; 
            return true ;

        }
        // recurtion
        // colume loop
        for (int i = 0; i < board.length; i++) {
            if (issafe(board, row, i)) {
                board[row][i] = 'Q';
                if ( nqueenonly(board, row+1)) {
                  return true ;   
                }  // funtion call
                board[row][i] = 'x'; // backtrack step

            }
        }
        return false ; 
    }
  // this is my best case ; 
    public static void nqueen(char board[][], int row) {
        // base case
        if (row == board.length) {
            printboard(board);
            count ++ ; 
            return;

        }
        // recurtion
        // colume loop
        for (int i = 0; i < board.length; i++) {
            if (issafe(board, row, i)) {
                board[row][i] = 'Q';
                nqueen(board, row + 1); // funtion call
                board[row][i] = 'x'; // backtrack step

            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        char board[][] = new char[n][n];
        // initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
      //  nqueen(board, 0);
        // System.out.println( " TOTOL way is = "+ count);
        if (nqueenonly(board, 0)) {
             System.out.println( "solution is possible ");
             printboard(board);
        }else{
          System.out.println("solution is not possible ");   
        }
    }
}
