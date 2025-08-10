package Assingmants.FunctionSection;

public class Prime {


    // first approch
    public static boolean isprime(int n  , int y ) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /// approch must use
    public static boolean isprime(int n) {
        if (n == 2) {
            return true;

        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }
   // prime number range print 
    public static void primeInRange(int n) { 
        
        for (int i = 2; i <= n; i++) {
            if (isprime(i)) {
                System.out.print(i + " ");
        
            }
            // true
        }
        System.out.println();
    }

    public static void main(String[] args) {
  
        primeInRange(5); 
   System.out.println(isprime(5, 0 ) ) ;

        
    }
}
