import java.util.Arrays;

public class Radix {
    // Radix
    public static void radixsort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        // do count sort for every digit place ;
        for (int exp = 1; max / exp > 0; exp *= 10) {
            Countsort(arr, exp);
        }
    }

    public static void main(String[] arg) {
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
        System.out.println("  Origin array : " + Arrays.toString(arr));
        radixsort(arr);
        System.out.println("  Sorted array  array : " + Arrays.toString(arr));

    }

    public static void Countsort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        System.out.println("CounT  array for " + exp + ": " + Arrays.toString(count));
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];

        }
        System.out.println(" Updated count  array for " + Arrays.toString(count));

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        System.out.println(" output count  array for " + Arrays.toString(output));

        System.arraycopy(output, 0, arr, 0, n);
    }

}
