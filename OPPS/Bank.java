//package OPPS;
//
//import java.io.IOException;
//
//class BankingException extends Exception{
//     public BankingException(String msg){
//         super(msg);
//     }
//}
//
//class InnerBank {
//   void getName()  {
//    System.out.println("sbi innr baknk ");
//  }
//}
//
//public class Bank extends InnerBank {
//   public void getName() {
//         System.out.println("Sbi bank");
//    }
//public static void main(String[] args) {
//    Bank bk = new Bank() ;
//    try{
//    bk.getName();
//
//    }catch(IOException e ){
//         e.getMessage();
//    }
//
//}
//
//}