package Revision;

public class TwoDArrays {

  public  static void spiralMatrix(int [][] arr){
       int startRow = 0 , endRow = arr.length-1 ;
       int startCol = 0 , endCol = arr[0].length-1 ;

       while(startRow<= endRow && startCol <= endCol ){

           // top
           for(int i = startCol ; i<=endCol ; i++){
               System.out.print(arr[startRow][i]);
               System.out.println("top");
           }
           //right
           for(int i = startRow+1 ; i<=endRow ; i++){

               System.out.print(arr[i][endCol]);

               System.out.println("right");

           }
           //bottom
           for(int i = endCol-1 ; i>=startCol ; i--){
               if(startRow == endRow){
                   break ;
               }
               System.out.print(arr[endRow][i]);
               System.out.println("bottom");

           }
           //left
           for(int i = endRow -1 ; i>= startRow+1; i--){
               if(startCol == endCol ){
                   break ;
               }
               System.out.print(arr[i][startCol]);
               System.out.println("left");
           }
           startRow++;
           startCol++;
           endRow--;
           endCol--;
       }

  }
   static  void DiagonalSum(int [][]mat){
      int n = mat.length ;
       int sum = 0 ;
       for(int i = 0 ; i<n ;i++){
           //primary diognal
           sum += mat[i][i] ;
           if(i != n-i-1)
            sum +=  mat[i][n-i-1];
       }
       System.out.println(sum);
   }

   static boolean search(int [][] mat ,int  target ){
       int row = mat.length-1;
       int col = 0 ;
       int n = mat.length ;
       int m = mat[0].length ;
       while(row<= n-1 && col <= m-1 && col >= 0 && row >= 0 ){
            if(mat[row][col] == target ){
                 return true;
            }
            if(mat[row][col] > target){
                 row-- ;
            }else{
                 col++;
            }
       }
       return false ;
   }
   public static  int [][] trasnpose(int [][] mat){
   int n = mat.length;
   int m = mat[0].length ;

   int [][] arr = new int [m][n];

     for(int i = 0 ; i<n ; i++){
          for(int j = 0 ; j<m ; j++){
                arr[j][i] =mat[i][j] ;
          }
     }
     return arr ;
   }
  public   static void main() {
        int [][] mat = {
                {1 , 2 } ,
                {5 , 6 } ,
                {9 , 10 } };

//        spiralMatrix(mat);
//      DiagonalSum(mat);
//      System.out.println(search(mat , 12));
      int [][] arr = trasnpose(mat);
      for(int i = 0 ; i<arr.length; i++){
           for(int j = 0 ; j<arr[0].length ; j++){
               System.out.print(arr[i][j]+" ");
           }
          System.out.println();
      }


    }
}
