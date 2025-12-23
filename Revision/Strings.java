package Revision;

public class Strings {
   public static void main() {
       pathdistace("WNEENESENNN");
    }

    public static  void pathdistace(String str){
        int x = 0 ;
        int y = 0 ;
        for(char ch : str.toCharArray()){
             if(ch=='E'){
              y++;
             }else if(ch =='W'){
              y--;
             }else if(ch == 'N'){
               x++ ;
             }else {
                x--;
             }
        }

        System.out.println(Math.sqrt(x*x + y*y));
    }
    public static  boolean palindrom(String str){
        int st = 0 ;
        int ed = str.length()-1 ;
        while(st <= ed){
             if(str.charAt(st) != str.charAt(ed)){
                  return false ;
             }
             st++ ;
             ed-- ;
        }
        return true ;
    }
}
