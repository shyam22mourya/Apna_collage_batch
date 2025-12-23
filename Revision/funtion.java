package Revision;

import Queue.Dueue.stack;

public class funtion {
    static void startPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pyramid(int n) {
        char ch = 'A';
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch++);
            }
            System.out.println();
        }
    }

    static void hollowRec(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1 || j == n || i == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void rotatedHalfPyramid(int n) {
        for (int i = 1; i <= n; i++) {

            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void invertedHalfPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void floydTriangle(int n) {
        int ch = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(ch++);
            }
            System.out.println();
        }
    }

    static void ZeroOneTriangle(int n) {
        boolean ch = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (ch) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
                ch = !ch;
            }
            System.out.println();
        }
    }

    static void butterflyPatter(int n) {
        int star = 1;
        int space = n - 2;
        int i = 1;
        while (i <= n) {
            // star
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 1; j <= space; j++) {
                System.out.print("-");
            }
            // star
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }

            if (i > (n / 2)) {
                space += 2;
                star--;
            } else if (i == n / 2) {
            } else {
                space -= 2;
                star++;
            }
            i++;
            System.out.println();
        }
    }

    static void HollowRhombus(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("-");
            }
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }

    }

    static void numberPatter(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(+i + " ");
            }
            System.out.println();
        }
    }

    static void palindrominPatter(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i - j + 1);
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void maxSum(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }
        int cs = arr[0], ms = arr[0];

        for (int j = 0; j < n; j++) {
            System.out.println(cs + " " + ms);
            cs = Math.max(arr[j], cs + arr[j]);
            ms = Math.max(ms, cs);
        }

        System.out.println(ms);
    }

    public static void trappingWater(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        int right[] = new int[n];
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        // trapping water
        int water = 0;
        for(int i = 0 ; i<arr.length ; i++){
             //water lelver
              water += (Math.min(left[i], right[i])-arr[i] );
        }
System.out.println(water);
    }

    public static void main(String[] args) {
        // numberPatter(5);
        int[] arr = { 4,2,0,6,3,2,5 };
       trappingWater(arr);
    }
}
