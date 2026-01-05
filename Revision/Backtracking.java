package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

    static int gridWay(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i < 0 || j < 0 || i >= n || j >= m) {
            return 0;
        }
        int up = gridWay(i + 1, j, n, m);
        int down = gridWay(i, j + 1, n, m);
        return up + down;
    }

    public static void main(String[] args) {

        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        printSudoku(sudoku);
        sudokuSolver(sudoku, 0, 0);
    }

     public static void ratInmaze(int [][] maze , int i , int j , int n , int m , boolean visit [][] , String msg ){
         if(i==n-1 && j == m-1){
             System.out.println(msg);
             return ;
         }
         if(i< 0 || j<0 || i>= n || j>= m || visit[i][j] || maze[i][j] == 0  ){
              return ;
         }
         visit[i][j] = true;
         ratInmaze(maze , i+1, j,   n  , m , visit , msg+'R');
         ratInmaze(maze , i-1, j,   n  , m , visit , msg+'L');
         ratInmaze(maze ,  i, j+1,  n  , m , visit , msg+'U');
         ratInmaze(maze ,  i, j-1 , n  , m , visit , msg+'D');
         visit[i][j] = false ;
     }
    public static void sudokuSolver(int[][] sudoku, int row, int col) {
        if (row == 9) {
            printSudoku(sudoku);
            return;
        }

        int newRow = row;
        int newCol = col + 1;

        if (newCol == 9) {
            newRow++;
            newCol = 0;
        }

        if (sudoku[row][col] != 0) {
            sudokuSolver(sudoku, newRow, newCol);
            return;
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe2(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                sudokuSolver(sudoku, newRow, newCol);
                sudoku[row][col] = 0; // backtracking
            }
        }
    }

    public static boolean isSafe2(int[][] sudoku, int row, int col, int digit) {
        // vertical
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) return false;
        }

        // horizontal
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit) return false;
        }

        // 3x3 box
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) return false;
            }
        }
        return true;
    }

    static void printSudoku(int[][] board) {
        System.out.println("------ SOLVED SUDOKU ------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void backTrack(int[] arr, int i) {
        if (arr.length == i) {
            return;
        }
        arr[i] = i + 1;
        backTrack(arr, i + 1);
        arr[i] = arr[i] - 2; // backtracking
    }

    static void subset(String str, int i, String ans, List<String> list) {
        if (i == str.length()) {
            list.add(ans);
            return;
        }
        subset(str, i + 1, ans + str.charAt(i), list); // pick
        subset(str, i + 1, ans, list);                  // not pick
    }

    static void permutation(String str, String newStr, List<String> list) {
        if (str.isBlank()) {
            list.add(newStr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String newst = str.substring(0, i) + str.substring(i + 1);
            char ch = str.charAt(i);
            permutation(newst, newStr + ch, list);
        }
    }

    static boolean isSafe(char[][] chesh, int row, int col) {
        // vertical
        for (int i = row; i >= 0; i--) {
            if (chesh[i][col] == 'Q') return false;
        }

        // left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chesh[i][j] == 'Q') return false;
        }

        // right diagonal
        for (int i = row, j = col; i >= 0 && j < chesh.length; i--, j++) {
            if (chesh[i][j] == 'Q') return false;
        }
        return true;
    }

    static void nQueenProblem(char[][] chesh, int row) {
        if (row == chesh.length) {
            print(chesh);
            return;
        }

        for (int i = 0; i < chesh.length; i++) {
            if (isSafe(chesh, row, i)) {
                chesh[row][i] = 'Q';
                nQueenProblem(chesh, row + 1);
                chesh[row][i] = '.'; // backtracking
            }
        }
    }

    static void print(char[][] chesh) {
        System.out.println("______________Chess______________");
        for (int i = 0; i < chesh.length; i++) {
            for (int j = 0; j < chesh.length; j++) {
                System.out.print(chesh[i][j] + " ");
            }
            System.out.println();
        }
    }
}
