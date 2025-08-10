package Assingmants.FunctionSection;

public class Pattern {
    public static void Hollow_rec(int n) {
        int m = 5;
        for (int line = 1; line <= n; line++) {
            // print stat
            for (int j = 1; j <= m; j++) {
                if (line == 1 || j == 1 || line == n || j == m) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            } // next line
            System.out.println();
        }
    }

    public static void inver_piramid(int n) {
        int space = n - 1;
        int star = 1;
        for (int line = 1; line <= n; line++) {
            // space
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            // next line
            System.out.println();
            space--;
            star++;

        }
    }

    public static void Rever_pyramid(int n) {
        for (int line = 1; line <= n; line++) {
            for (int j = 1; j <= n - line + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void Floyd(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }

    }

    public static void Tringle01(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 1) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();

        }
    }

    public static void Butterfly(int n) {
        int space = 2 * n - 2;
        int star = 1;
        int line = 1;
        while (line <= 2 * n) {
            // star
            for (int j = 0; j < star; j++) {
                System.out.print("* ");
            }
            // space
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }
            // star
            for (int j = 0; j < star; j++) {
                System.out.print("* ");
            }  

            // next line 
             System.out.println();
            if (  line < n ){
                 space -=2  ; 
                 star ++ ; 
            } 
            else if ( line> n ){ 
                 space+=2; 
                star-- ; 
            }
line ++ ; 
        }
    }

    public static void main(String[] args) {
        Hollow_rec(4);
        inver_piramid(4);
        Rever_pyramid(5);
        Floyd(5);
         Tringle01(5);
         Butterfly(4);
    }
}
