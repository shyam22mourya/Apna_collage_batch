package Assingmants;
public class TwoD {
    public static void Q1(int martix[][]) {
        int count7 = 0;
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[0].length; j++) {
                if (martix[i][j] == 7) {
                    count7++;
                }
            }
        }
        System.out.println(" 7 found " + count7 + " Times ");
    }

    public static void Q2(int martix[][]) {
        int sum = 0;
        for (int i = 0; i < martix[0].length; i++) {
            sum += martix[1][i];
        }
        System.out.println(" sum 1 Index " + sum);
    }

    public static void Q3(int[][] max) {
        System.out.println("The martix is : ");
        for (int i = 0; i < max.length; i++) {
            for (int j = 0; j < max[0].length; j++) {
           System.out.print(max[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int row = 3 ,col = 3; 
        // int matrix[][] = { { 4, 7, 8 }, { 8, 8, 7 } };
        int arr[][] = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
            
        //    Display original matrix; 
         Q3(arr);

         // transponsed the matrix ; 
         int [][] transposed  =  new int[col][row] ; 
         for ( int i = 0 ; i< row ; i++){
              for ( int j = 0 ; j<col ; j++){
                  transposed[j][i] = arr[i][j] ;                
             }
          } 

           Q3(transposed);
    }
}
