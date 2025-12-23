package Revision;

public class sorting {
    static void bubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length; turn++) {
            for (int j = 0; j < arr.length - turn - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void selection(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minpos = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minpos] > arr[j]) {
                    minpos = j;
                }
            }

            int temp = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }

    static void countingSort(int[] arr) {
        int large = Integer.MIN_VALUE;
        for (int i : arr) {
            large = Math.max(i, large);
        }
        int count[] = new int[large + 1];
        for (int i : arr) {
            count[i]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j++] = i;
                count[i]--;
            }
        }
    }

    public static int mergeSort(int[] arr, int st, int ed) {
        if (st >= ed) {
            return 0 ;
        }
        int mid = (st + ed) / 2;
        int cnt = 0 ;
       cnt+= mergeSort(arr, st, mid);
       cnt+=  mergeSort(arr, mid + 1, ed);
       cnt+= mergeSort(arr, st, mid, ed);
     return  cnt ;
    }

    public static int mergeSort(int arr [] , int st , int mid , int ed ) {
        int i = st;
        int j = mid + 1;
        int k = 0;
        int cnt = 0 ;
        int temp[] = new int[ed - st + 1];
        while (i <= mid && j <= ed) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                cnt += (mid-i+1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid ) {
            temp[k++] = arr[i++];
        }

        while (j <= ed) {
            temp[k++] = arr[j++];
        }
       k = 0 ; 
        for(int t = st ; t<=ed ; t++ , k++){
             arr[t]= temp[k];
        }
return cnt ;
    }

    public static  void quickSort(int arr[] , int st , int ed ){
        //  no extra space ,

        if(st >= ed) return ;

        int pivt = partition(arr , st , ed);
        quickSort(arr , st , pivt-1 );
        quickSort(arr , pivt+1 , ed);
    }

    public  static  int partition(int arr [] , int st , int ed ){
         int pivit = arr[ed];

         int i = st-1;
         for(int j = st ; j<ed ; j++){
              if(arr[j] < pivit){
                  i++;
                  int temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp ;
              }
         }

         i++;
         int temp = arr[i];
         arr[i] = pivit;
         arr[ed] = temp ;

         return i ;
     }

     public  static  int minSearch(int arr [] ){
       int st = 0 ;
       int ed = arr.length -1;

        while(st <= ed){
             int mid = st +(ed-st)/2 ;
             if(mid > 0 && arr[mid -1] > arr[mid] ){

                  return mid ;
             }


             if(arr[st] <=  arr[mid] && arr[mid] >= arr[ed]){
                 st = mid+1;
             }else{
                 ed = mid-1;
             }
        }
        return -1;
     }


     public  static int searchSorted(int arr[] , int st , int ed , int key  ){
         // base base ;
         if(st > ed) return - 1;
         // kaam
         int mid = st +(ed-st)/2 ;
          if(arr[mid]== key){
               return mid ;
          }

          // line one
         if(arr[st] <= arr[mid]){
               if(arr[st] <= key && arr[mid] >= key){
                return  searchSorted(arr ,st, mid-1 , key );
               }else{
                 return    searchSorted(arr ,mid+1 ,ed , key);
               }
         }else{ // line two
             if(arr[ed] >=  key && arr[mid] <= key){
             return     searchSorted(arr ,mid+1, ed , key );
             }else{
             return     searchSorted(arr ,st ,mid-1 , key);
             }
         }

     }

     public  static void    mergeSortSt(String arr[]  ,int st , int ed ){
         if(st >= ed) return ;
         int mid = (st+ed)/2 ;

         mergeSortSt(arr , st , mid );
         mergeSortSt(arr , mid+1 , ed);
         mergeSortSt(arr, st ,mid , ed );

 }
 public  static void mergeSortSt(String arr[] , int st , int mid , int ed){
        String [] temp = new String[ed-st+1];
         int i = st ;
         int j = mid+1;
         int k = 0 ;

         while ( i <= mid && j <= ed) {
             if (arr[i].compareTo(arr[j]) < 0) {
                 temp[k++] = arr[i++];
             } else {
                 temp[k++] = arr[j++];
             }
         }

         while(i<= mid){
             temp[k++] = arr[i++];
         }
         while(j<= ed){
             temp[k++] = arr[j++];
         }

         for(k = 0 , i = st ;i<=ed ; k++, i++){
              arr[i] = temp[k];
         }

 }




     public static void main(String[] args) {
        int arr[] = { 2,2,1,1,1,2,2};
         System.out.println(mergeSort(arr , 0 , arr.length-1));
        // bubbleSort(arr);
        // selection(arr);
        // insertionSort(arr);
//        mergeSort(arr, 0, arr.length-1);
        int sort [] = {4,5,6,7,1,2,3};
//        System.out.println(minSearch(sort));
//        quickSort(arr , 0 , arr.length-1 );
//         System.out.println(searchSorted(sort , 0 , sort.length-1 , 3));
        for (int i : arr) {
            System.out.print(i + " ");
        }

//         String [] strings = {"mango" , "orange","graphs","banana","watermalon"};
//         mergeSortSt(strings , 0 ,strings.length-1  );
//         System.out.println(strings[0].compareTo(strings[1]));
//         for(String i : strings){
//             System.out.println(i);
//         }
//        }
    }
}
