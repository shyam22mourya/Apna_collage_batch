package Assingmants.FunctionSection;

public class DectoBin {
    public static void DecToBin(int Dec) {
        int myNum = Dec;

        int pow = 0;
        int bin = 0;

        while (Dec > 0) {
            int rem = Dec % 2;
            bin = bin + (int) (rem * Math.pow(10, pow));

            pow++;
            Dec = Dec / 2;
        } 
         System.out.println (myNum+"Decimal to  =  "+  bin );
    }

    public static void main(String[] args) {
      DecToBin(10);
    }
}
