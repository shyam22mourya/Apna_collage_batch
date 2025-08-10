import java.util.*;

public class shyam {
     public static int factorail(int n) {
          int fac = 1;
          for (int i = 1; i <= n; i++) {
               fac *= i;
          }
          return fac;
     }

     public static int bincoeff(int n, int r) {
          int fact_n = factorail(n);
          int fact_r = factorail(r);
          int fact_nr = factorail(n - r);

          int bincoeff = fact_n / (fact_r * fact_nr);
          return bincoeff;
     }

     public static void main(String[] args) {
          System.out.println(bincoeff(7, 5));
     }
}
