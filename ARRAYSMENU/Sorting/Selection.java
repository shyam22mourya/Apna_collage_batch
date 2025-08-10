package ARRAYSMENU.Sorting;
public class Selection {
    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minpos = i;
            for (int l = i + 1; l < arr.length; l++) {
                if (arr[minpos] > arr[l]) {
                    minpos= l ;
                }
            }
            //swap 
             int temp = arr[minpos] ; 
              arr[minpos] = arr[i] ; 
               arr[i] = temp ; 
        }
    }
    public static void printarr(int [] nums){
        for ( int i = 0 ; i<nums.length; i++){
          System.out.print(nums[i]+" ");
        } 
        System.out.println();
      }

    public static void main(String[] args) {
        int []arr = {5,4,1,3,2};
        selection(arr);
printarr(arr);
    }
}
