import java.util.Scanner;

public class StartTwoD {
    public static boolean search(int[][] martix, int target) {
         int count = 0 ;
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[0].length; j++) {
                if (martix[i][j] == target) {
                    System.out.println("found at cell ( "+i+","+j+" )");
                 count++ ; 
                }
            }
        } 
         if ( count >= 1 ){
              return true  ; 
              
         }
        return false;
    }

    public static void main(String[] args) {
        // M * N ; M=ROW , N = COLLUMS ;
        // input ;
        int Matrix[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        int n = Matrix.length, m = Matrix[0].length;
        ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Matrix[i][j] = sc.nextInt();
            }
        }
        // Out put
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
       System.out.println(search(Matrix,  5 )  ); 
    }
}