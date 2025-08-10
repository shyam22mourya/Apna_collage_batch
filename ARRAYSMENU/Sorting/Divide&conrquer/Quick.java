public class Quick {

    public static void main(String[] args) {
        int[] arr = { 6, 3, 4, 8, 2, 5 ,-1};
        quick(arr, 0, arr.length - 1);
        printarr(arr);
    }

    public static void quick(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pidx = partition(arr, si, ei);
        quick(arr, si, pidx - 1);
        quick(arr, pidx + 1, ei);
    }

    public static int partition(int[] arr, int si, int ei) {
        int piv = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= piv) {
                i++; // if pvit se chota element ho to ;
                int tem = arr[j];
                arr[j] = arr[i];
                arr[i] = tem;
            }
        }
        i++;
        int tem = piv;
        arr[ei] = arr[i]; // pivit = arr[i] ;
        arr[i] = tem;
        return i;
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
