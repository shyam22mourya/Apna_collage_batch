package ARRAYSMENU.Sorting;

public class Bubble {
   public static void bubblesort(int[] nums) {

      for (int turn = 0; turn < nums.length; turn++) {

         for (int j = 0; j < nums.length - 1 - turn; j++) {

            if (nums[j] >  nums[j + 1]) {
               int temp = nums[j];
               nums[j] = nums[j + 1];
               nums[j + 1] = temp;
            }
         }
      }
   }

   


  public static void printarr(int [] nums){
    for ( int i = 0 ; i<nums.length; i++){
      System.out.print(nums[i]+" ");
    } 
    System.out.println();
  }
   public static void main(String[] args) {
      // int arr[] = { 5, 4, 1, 3, 2 };
      int[] arr = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };

bubblesort(arr);
 printarr(arr);
   }
}
