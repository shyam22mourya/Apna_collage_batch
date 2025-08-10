package ARRAYSMENU.Arrays;

public class Reverse {

   public static void reverse(int[] num) {
      int start = 0, end = num.length - 1;
      while (start < end) {
         int tem = num[end];
         num[end] = num[start];
         num[start] = tem;

         start++;
         end--;
      }
   }

   public static void main(String[] args) {
      int[] num = { 2, 4, 6, 8, 10, 12 };
      reverse(num);
      for (int i = 0; i < num.length; i++) {
         System.out.print(num[i] + " ");
      }
      System.out.println();
   }

}