package Bit.Strings;
public class Qstring {
    public static boolean ispalldom(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static Float getshortestpath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {

            char div = str.charAt(i);
            if (div == 'E') {
                x++;
            } else if (div == 'W') {
                x--;
            } else if (div == 'N') {
                y++;
            } else {
                y--;
            }
        }
        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);
    }

    public static void sudstrin(String str, int si, int ei) {
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i);
        }
        System.out.print(substr);

    }

    public static void main(String[] args) {
        String fruits[] = { "applle", "banana", "mango" };
        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
    //     String str = "WNEENESENNN";
    //     String sub = "helloworld";
    //     System.out.println(getshortestpath(str));
    //     sudstrin(sub, 0, 5);
    System.out.println(largest);
     }
}
