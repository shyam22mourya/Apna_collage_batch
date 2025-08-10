package Assingmants;

// import java.util.Scanner;

public class St {
   public static void replace(){
     String kri = "Apnacollage".replace("coll", "");
     System.out.println(kri);

   }
  public static void tolowervowel(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        count++;
      }
    }
    System.out.println("voxel is :" + count);
  }

  public static boolean nam(String st1, String srt2) {

    int st[] = new int[26];
    for (int ind = 0; ind < st1.length(); ind++) {
      char ch = st1.charAt(ind);
      st[ch - 'a']++;
    }

    int st3[] = new int[26];
    for (int ind = 0; ind < srt2.length(); ind++) {
      char ch = srt2.charAt(ind);
      st3[ch - 'a']++;
    }

       for( int idx = 0; idx <26; idx++){
         if ( st[idx]!=st3[idx]){
           return false ; 
        }
      }
      return true ;
  }

  public static void main(String[] args) {
    // String str1 = new Scanner(System.in).next();
    // String str2 = new Scanner(System.in).next();
    
    // System.out.println(nam(str1 , str2));
    replace();
  }
}
