import java.util.*;

public class basic {
  // Q1 Activity selection code

  public static void activityselection(int start[], int end[]) {
    // step 1 sorting
    int act[][] = new int[start.length][3];
    for (int i = 0; i < start.length; i++) {
      act[i][0] = i;
      act[i][1] = start[i];
      act[i][2] = end[i];
    }
    // this lemda function
    // this is also celled big function ;
    Arrays.sort(act, Comparator.comparingDouble(o -> o[2]));
    // end based time sorted
    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    // 1st activity
    maxAct = 1;
    ans.add(act[0][0]);
    int lastEnd = act[0][2];
    for (int i = 0; i < end.length; i++) {
      if (act[i][1] >= lastEnd) {
        // activity select
        maxAct++;
        ans.add(act[i][0]);
        lastEnd = act[i][2];
      }
    }
    System.out.println("maxactivity " + maxAct);
    for (int i = 0; i < ans.size(); i++) {
      System.out.println("A" + ans.get(i));
    }
  }

  // Q2 freactinal knapsack ;
  public static void freactinalKnapsack(int val[], int weight[], int w) {
    // create 2D array
    double ratio[][] = new double[val.length][2];
    // 0th col => = idx ; 1st col => ratio
    for (int i = 0; i < val.length; i++) {
      ratio[i][0] = i;
      ratio[i][1] = val[i] / (double) weight[i];
    }
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
    int capacity = w;
    int ans = 0;
    for (int i = ratio.length - 1; i >= 0; i--) {
      int idx = (int) ratio[i][0];
      if (capacity >= weight[idx]) { // include full item
        ans += val[idx];
        capacity -= weight[idx];
      } else { // include fractional item
        ans += (ratio[i][1] * capacity);
        capacity = 0;
        break;
      }
    }
    System.out.println("final value " + ans);
  }

  // Q3 min Absulate different pairs
  public static void minAbs(int[] A, int[] B) {
    // Step 1 ; sort both pair
    Arrays.sort(A);
    Arrays.sort(B);
    // step 2 :
    int mindiff = 0;
    for (int i = 0; i < A.length; i++) {
      mindiff += Math.abs(A[i] - B[i]);
    }
    System.out.println(" Min Absulate diffrent pairs " + mindiff);
  }

  // Q4 min length chair of pairs

  public static void maxLength(int pairs[][]) {
    Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
    int chairlength = 1;
    int lastEnd = pairs[0][1];
    for (int i = 0; i < pairs.length; i++) {
      if (pairs[i][0] > lastEnd) {
        chairlength++;
        lastEnd = pairs[i][1];
      }
    }

    System.out.println(" Maxlength of chairs pair " + chairlength);
  }

  // Q5 Indian coin
  public static void Indiancoin(Integer coin[], int amount) {
    Arrays.sort(coin, Comparator.reverseOrder());
    int cnt = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < coin.length; i++) {
      if (coin[i] <= amount) {
        while (coin[i] <= amount) {
          cnt++;
          ans.add(coin[i]);
          amount -= coin[i];
        }
      }
    }

    System.out.println( " TOTOAL COINS USED  =  "+ cnt);

     for( int i = ans.size()-1 ; i>=0; i--){
       System.out.print(ans.get(i)+  " ");
     }
     
  }
//Q 6 Jod of sequence  
  public static void jodofseq( int[][]jodinfo){
     ArrayList <Jod>  jods = new ArrayList<>() ; 
       for( int i = 0 ; i<jodinfo.length ; i++){
         jods.add(new Jod(jodinfo[i][0], jodinfo[i][1] , i )) ; 
       }

       Collections.sort( jods , (a ,b) -> b.profit -a.profit); // desecding 
           int time =  0  ; 
           ArrayList<Integer> ans  = new ArrayList<>() ; 
           for ( int i = 0 ; i< jods.size() ; i++){
             Jod curr =  jods.get(i) ; 
             if (curr.deadline > time) {
              ans.add(curr.idx) ; 
              time++ ; 
             }
           }
// print seq  
 System.out.println( " Max jods  length "+ ans.size());
 for( int i = 0 ; i< ans.size() ; i++){ 
  System.out.print(ans.get(i)+ " ");
 }

  }
  static  class Jod {
     int  deadline ; 
      int profit ; 
       int idx  ; 
         public Jod( int d , int p , int i ){
           deadline  = d ; 
           profit = p ; 
            idx = i ; 
         }
  }

  //Q 7  CHOCOLA PROBLEM 
  public static void  chocolaproblem (  int n  , int m ,  Integer []  conHor  , Integer [] conVer){
    // step 1  sort the array 
    Arrays.sort( conHor , Collections.reverseOrder());    
    Arrays.sort( conVer , Collections.reverseOrder());    

      int h = 0 , v = 0 ; 
      int hp = 1 , vp = 1 ;  
      int cost = 0 ; 
      while (h< conHor.length && v< conVer.length) { 
         if ( conHor[h] <= conVer[v]) {  // vertical cut ; 
          cost += conVer[v]*hp ; 
          vp++  ; 
          v++ ;    
          
         }else{ // Horizontial cut ; 
          cost += conHor[h]*vp  ; 
          hp++ ; 
          h++ ; 
         }
        
      } 
      while (h< conHor.length) {
        cost += conHor[h]*vp ; 
        hp++  ; 
        h++ ;  
      }

      while (v< conVer.length) {
        cost += conVer[v]*hp  ; 
        vp++ ; 
        v++ ; 
      }
        System.out.println(  " min cost of cuts "+ cost);
  }
 // Greedy Algorithm for Egyptian Fraction
 public static void  EgyptianFraction( int nr  , int dr){
    
   // if  numerator and denomirator doth are zero 
    if (nr ==0 || dr ==0 ) {
       return  ; 
    }
 
     if (dr% nr==0) {
      System.out.print( "1/"+dr/nr+" ");
      return ; 
     }

      if (nr% dr == 0 ) {
        System.out.print( dr/nr+" ");  
         return ; 
      }
    
     // if numerator is greater than deno 
       if (nr> dr ) {
       System.out.print("1/"+ nr/dr +"+"); 
       EgyptianFraction(nr%dr, dr);
       }

        int n = dr/nr+1; 
         System.out.print( "1/"+n+" " ) ; 
           EgyptianFraction( nr*n-dr, dr*n);
           return; 
 }
  public static void main(String[] args) {
    int nr = 5 ; 
     int dr = 7 ; 
      System.err.print(nr+"/"+dr +" = ");
      EgyptianFraction(nr, dr);
  }
}
