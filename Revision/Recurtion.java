package Revision;


public class Recurtion {

    static  void pringNToone(int n ){
         if(n==0 )  // base case
             return;
        System.out.println(n);
        pringNToone(n-1);

    }

    static  int fact(int n ){
         if(n==0){
              return 1;
         }
         return n *fact(n-1);
    }

    static  int fabunacchi(int n ){
         if(n==1 || n==0){
              return n ;
         }
         int n1 = fabunacchi(n-1);
         int n2 = fabunacchi(n-2);

         return n1+n2 ;
    }

    static boolean  isSorted(int arr [] , int i ){
         if(i== 0 ) return true;

         if(arr[i] <  arr[i-1] ) return false  ;
          return isSorted(arr , i-1 );
    }

    static int tillingProblem(int n){
         if(n==0 || n==1){
             return 1 ;
         }

         return tillingProblem(n-1)+tillingProblem(n-2);
    }

    static String  removeDup(String str ,int index , boolean[] fre ,StringBuilder sb ){
         if(index == str.length()){
              return sb.toString()  ;
         }
         char ch = str.charAt(index);
         if(!fre[ch-'a']){
              sb.append(ch);
              fre[ch-'a']=true;
         }
      return removeDup(str , index+1 , fre , sb ) ;
    }

    static int frientsPairing(int n){
         if(n==1 || n==2){
             return n ;
         }
          return (n-1)*frientsPairing(n-2)+frientsPairing(n-1);
    }

    static  void printBinary(int lastChar , StringBuilder sb  , int n ){
         if(n==sb.length() ){
             System.out.println(sb);
             return ;
         }


        // Add 0
        sb.append('0');
        printBinary(0, sb, n);
        sb.deleteCharAt(sb.length() - 1);

        // Add 1 only if last char was 0
        if (lastChar == 0) {
            sb.append('1');
            printBinary(1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
         }
    }

    static  void findOccure(int [] arr , int i , int key){
         if(i==arr.length){
              return ;
         }
        if(arr[i]==key){
            System.out.println(i);
        }
         findOccure(arr , i+1 , key);
    }

    static  void pringNum(String [] arr  , int num , String sb ){
        if(num == 0 ){
            System.out.println(sb);
            return;
        }
        int nums= num %10 ;
        sb = arr[nums]+ sb ;

        pringNum(arr , num/10 , " "+sb);
    }
    static int ans = 0;

    static void countSubstrings(String str, int start, int end) {
        // base case: when start reaches end of string
        if (start == str.length()) {
            return;
        }

        // if end goes out of bounds, move start forward
        if (end == str.length()) {
            countSubstrings(str, start + 1, start + 1);
            return;
        }

        // check first and last char
        if (str.charAt(start) == str.charAt(end)) {
            ans++;
        }

        // expand current substring
        countSubstrings(str, start, end + 1);
    }
    static  void towerHowoi(int n , String src , String  helper , String des){
         if(n==1){
             System.out.println( "shift "+n+"th "+src +" "+ des);
             return;
         }

         //  if n src to helper using des
         towerHowoi(n-1 , src , des , helper);
         // source to soorce to des
        System.out.println( "shift "+n+"th "+src +" "+ des);
        // n-1 helper to destination
         towerHowoi(n-1 , helper , src , des  );
    }



    public  static void main() {
String [] arr = {"zero","one","two","three" ,"four","five","six","seven","eight","nine" };
//       pringNum(arr , 1947 , "");
//        countSubstrings("abcab",0 , 0 );
//        System.out.println(ans);
        towerHowoi(3 , "src" ,"helper","des");
    }

}
