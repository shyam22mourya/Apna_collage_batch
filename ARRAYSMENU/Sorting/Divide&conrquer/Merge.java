
public class Merge {
    public static void merge(int arr[], int si, int ed) {
          if ( si >=ed){
             return ;  
          }
        int mid = si + (ed - si)/2;
        merge(arr, si, mid);
        merge(arr, mid+1, ed);
        merge(arr, si, mid, ed);
    }
// merge method to marge the sorted parts 
    public static void merge(int arr[], int si, int mid, int ed) {
        int temp[] = new int[ed - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ed) {
            // Temp
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // fir left term elements of 1st sorted part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // fir left term elements of 2st sorted part
        while (j <= ed) {
            temp[k++] = arr[j++];
        }
        // temp copy to original
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 3, 7, 9, 0, 2 };
         merge(arr, 0, arr.length-1);
        printarr(arr);
    }
}
