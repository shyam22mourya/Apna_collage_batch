package FULLRECURTION.Backtrack.Recurtion;

public class Recurtion1 {
  // Check is given number is sorted ya not
  public static boolean isBoolean(int arr[], int i) {
    if (i == arr.length - 1) {
      return true;
    }
    if (arr[i] > arr[i + 1]) {
      return false;
    }
    return isBoolean(arr, i + 1);
  }

  // WAF TO FIND A FIST OCCURECE ;
  public static int Fistoccurse(int arr[], int key, int i) {
    if (i == arr.length) {
      return -1;
    }
    if (arr[i] == key) {
      return i;
    }
    return Fistoccurse(arr, key, i + 1);
  }

  // Waf to find a last occurence ;
  public static int lastocc(int arr[], int key, int i) {
    if (i == arr.length) {
      return -1;
    }

    int find = lastocc(arr, key, i + 1);

    if (find == -1 && arr[i] == key) {
      return i;
    }
    return find;

  }

  // write power function ;
  public static int pow(int x, int n) {
    if (n == 0) {
      return 1;
    }
    return x * pow(x, n - 1);
  }

  // write optimise power function ;
  public static int optipow(int x, int n) {
    if (n == 0) {
      return 1;
    }
    int half = optipow(x, n / 2);
    int half2 = half * half;

    if (n % 2 != 0) {
      half2 = x * half2;
    }
    return half2;

  }

  public static double morePow(int x, int n) {
    double ans = 1;
    double nn = n;
    if (n < 0) {
      nn = -1 * n;
    }
    while (nn > 0) {
      if (nn % 2 == 0) {
        x = x * x;
        nn = nn / 2;
      } else {
        ans = ans * x;
        nn--;
      }
    }
    if (n < 0) {
      ans = 1 / ans;
    }
    return ans;
  }

  public static void main(String[] args) {
    int arr[] = { 2, 9, 5, 7, 6, 7, 8 };
    System.out.println(morePow(2, -2));
  }
}
