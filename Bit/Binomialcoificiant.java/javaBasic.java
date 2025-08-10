
import java.util.Scanner;

public class javaBasic {

  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int space = n - 1;
    int star = 1;
    for (int line = 1; line <= n; line++) {

      // space
      for (int i = 0; i < space; i++) {
        System.out.print("  ");
      }

    // print stars  -> replace with number 
     int current_num = line ; 
      for ( int i = 0 ; i< star; i++){
         System.out.print(current_num+ " ");
         if (i <star/2 ){
           current_num--; 
         }else {
           current_num++ ; 
         }
      }

      // next
      System.out.println();
      space--;
      star+=2;
    }

  }
}
