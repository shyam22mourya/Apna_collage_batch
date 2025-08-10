package FULLRECURTION.Backtrack;
import java.util.Scanner;

public class Sudukusolver {
    public static void printsuku(int suduku[][]) {
        for (int i = 0; i < suduku.length; i++) {
            for (int j = 0; j < suduku.length; j++) {
                System.out.print(suduku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean issafe(int suduku[][], int row, int col, int digit) {
        // check in col wise ;
        for (int i = 0; i < 9; i++) {
            if (suduku[i][col] == digit) {
                return false;
            }
        }
        // check in row wise ;

        for (int i = 0; i < 9; i++) {
            if (suduku[row][i] == digit) {
                return false;
            }
        }
        // grid 
          int sr = (row/3)*3  ; 
          int en = (col/3)*3  ; 
           for  ( int i = sr ; i<sr+3 ; i++){
             for( int j = en  ; j <en+3; j++){
                 if (suduku[i][j] ==digit ){
                    return false ; 
                 }
             }
           }

        return true;
    }

    public static boolean sudukusolver(int suduku[][], int row, int col) {
        // base case
        if (row == 9) {
            return true;
        }
        // recurting

        int newROw = row;
        int newCol = col + 1; // calculating row and colume ;
        if (col + 1 == 9) {
            newROw = row + 1;
            newCol = 0;
        }

        if (suduku[row][col] != 0) {
            return sudukusolver(suduku, newROw, newCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (issafe(suduku, row, col, digit)) {
                suduku[row][col] = digit;
                if (sudukusolver(suduku, newROw, newCol)) { // solution exit ;
                    return true;
                }
                suduku[row][col] = 0;  
            }
        }
        return false;
    }

    public static void main(String agrs[]) {
         Scanner input = new Scanner(System.in ) ; 
        //   int  n = input.nextInt() ; 
          int sudu [][] = new int[9][9] ; 
          for( int i=  0 ;i<  9  ; i++){
             for ( int j = 0 ; j< 9 ; j++){
                sudu[i][j]= input.nextInt() ; 
             }
          }
       
//  int suduku [][]= { 
//     {0,0,3,1,4,7,0,0,0 },
//     {0,0,7,8,6,0,5,0,0,},
//     {1,0,8,9,0,3,0,0,7},
//     {9,8,6,5,2,0,0,7,0},
//     {0,4,2,0,0,0,0,0,0,},
//     {0,0,0,6,0,0,8,5,0},
//     {0,0,0,2,3,9,0,0,0,},
//     {0,0,0,0,1,0,3,8,5},
//     {0,6,0,0,0,5,1,2,9} 
//  } ;  

   if (sudukusolver(sudu, 0, 0)) {
     System.out.println(" solotion exist");
     printsuku(sudu);   
   }
   else { 
    System.out.println( " solution does not exist");
   }
    }
    
}
