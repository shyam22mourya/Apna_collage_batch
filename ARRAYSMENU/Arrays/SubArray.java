package ARRAYSMENU.Arrays;

public class SubArray {
     public static void subarr(int[] num) {
          int Ta = 0;
          for (int i = 0; i < num.length; i++) {
               int start = i;
               for (int j = i + 1; j < num.length; j++) {
                    int end = j;
                    int sum = 0;

                    for (int k = start; k <= end; k++) {
                         System.out.print(num[k] + " ");
                         sum = sum + num[k];
                    }
                    System.out.println();
                    Ta++;
                  //  System.out.println(sum);

               }
               System.out.println();

          }
          System.out.println(Ta);
     }

     public static void main(String[] args) {
          int[] num = { 2, 4, 6, 8, 10, 12 };
          subarr(num);

     }
}
