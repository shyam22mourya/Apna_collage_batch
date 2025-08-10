package Assingmants.FunctionSection;


public class Funtions {

    public static int calculate(int a, int b) { // THIS IS CALLED PARAMETERS || FORMEL PERAMETERS
        int roduct = a * b;
        return roduct;

    }

    public static void PERAMETERS() {
        System.out.println(" MY MAMMY IS OPPSITE OF ME ");
        System.out.println(" HELLO WORLD ");
    }

    public static void swap(int a, int b) {
        // swap

        int temp = a;
        a = b;
        b = temp;
        System.out.println(" a  = " + a);
        System.out.println(" b  = " + b);
    }

    public static void main(String[] args) {
    }

    public static void trigle(int m) {
        int num = 1;

        // print num
        for (int line = 1; line <= m; line++) {

            for (int j = 0; j < line; j++) {
                System.out.print(num + " ");
                if (num == 1) {
                    num--;
                } else {
                    num++;
                }

            }

            // next line
            System.out.println();

        }
    }

}
