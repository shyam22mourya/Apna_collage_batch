package FULLRECURTION.Backtrack.Recurtion;

import Bit.Strings.Stringbuilder;

public class Recurtion2 {
  // Q11 Tiling problem
  public static int tily(int n) {

    // base case
    if (n == 0 || n == 1) {
      return 1;
    }
    // 2*n // floor size
    // kam
    // vertical choise
    int ver1 = tily(n - 1);
    // horizontal choise
    int ver2 = tily(n - 2);
    int total = ver1 + ver2;
    return total;
  }
  // Q12 Remove duplicates in sa string

  public static void redu(String str, Stringbuilder newst, boolean[] map, int ind) {
    if (ind == str.length()) {
      System.out.println(newst);
      return;
    }

    char curr = str.charAt(ind);
    if (map[curr - 'a'] == true) { // for duplicare
      redu(str, newst, map, ind + 1);

    } else {
      map[curr - 'a'] = true;
      newst.append(curr);
      redu(str, newst, map, ind + 1);
    }
  }

  // prrblem of 13 ;
  // if YOU have friends and inveted your friends
  public static int friends(int n) {
    if (n == 1 || n == 2) {
      return n;
    } // single pair
    return friends(n - 1) + (n - 1) * friends(n - 2);
  }

  // Problem of 14 ; Binary String problem
  public static void Binarystring(int n, int lastplace, String str) {
    if (n == 0) {
      System.out.println(str);
      return;
    }
    // for every time print "0"
    Binarystring(n - 1, 0, str + "0");

    if (lastplace == 0) {
      Binarystring(n - 1, 1, str + "1");
    }

  }

  // tilling proble
  public static int till(int n) {
    // base
    if (n == 0 || n == 1) {
      return 1;
    }
    // kaam
    // vertical and horizontail
    return till(n - 1) + tily(n - 2);
  }

  public static void main(String[] args) {
    // Binarystring(3, 1, "");
  }

  public static int fac(int n) {
    // base case
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * fac(n - 1);
  }
}