public class Sorted {
  public static void main(String[] args) {
    int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
    int target = 0;
    int serind = seach(arr, 0, arr.length - 1, target);
    System.out.println(serind);
  }

  public static int seach(int[] arr, int si, int ei, int tar) {
    if (si > ei) {
      return -1;
    }
    int mid = si + (ei - si) / 2;
    if (arr[mid] == tar) {
      return mid;
    }
    // first lime
    if (arr[si] <= arr[mid]) {

      // case a
      if (arr[si] <= tar && tar <= mid) {
        return seach(arr, si, mid - 1, tar);
      } else {
        return seach(arr, mid + 1, ei, tar);
      }
    }
    // second line
    else {
      if (arr[mid + 1] <= tar && tar >= arr[ei]) {
        return seach(arr, mid + 1, ei, tar);
      } else {
        return seach(arr, si, mid - 1, tar);
      }
    }
  }
}
// time complexity   = O(nlogn )
