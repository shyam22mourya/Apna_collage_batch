package ARRAYSMENU.Arrays;

public class INVERTEDarrys { 
    
      public static int search ( int []nums , int target){
         int min = minSearch(nums) ; 
         // find  in sorted left 
          if ( nums[min] <= target  && target <=nums[nums.length-1]){ 
             return search(nums, target,  min , nums.length-1 ) ;
          }else
          //find  in sorted right 
          {
 return search(nums, target, 0, min) ; 
          }
     }

// for simple binary search find target left to right boundry   ; 
     public static int   search ( int [] nums ,  int target  , int left , int right ){
           int start = left  ; 
            int  end = right ; 
             while (start <= end) {
              int mid = (start +end)/2 ; 
                 if ( nums [mid]== target ){
                     return mid ; 
                 }
                 if ( target> nums[mid]){
                 start = mid+1; 
                 }else {
                    end = mid-1 ; 
                 }
             }
             return -1; 
     }
    public static int minSearch(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
                left = mid + 1;
            }
            else{
                right = mid-1 ; 
            }
        }
return left; 
    }

    public static void main(String[] args) {
   int [ ] nums = {4,5,6,7,1,2,3};
    int target  = 2 ; 
    System.out.println(search(nums, target)); 
    }
}
