package Assingmants;
import java.util.Stack;

public class StackQ {
      // Q 1 . CHECK IS PALLENDROM ;
       static class Node {
           char data ; 
            Node next ; 
               Node( char data){
               this.data = data ; 
                this.next = null ; 

               }
      }
       public Node head ; 
        public static boolean  isPallendrom(Node head){
            Node temp = head;
              Stack<Character>s = new Stack<>() ; 
             while (temp!= null) {
               s.push(temp.data) ; 
               temp =temp.next ; 
             }
           temp =head  ; 
            while (!s.isEmpty() && temp!= null) {
                 if (s.pop()!= temp.data) {
                     return false ; 
                 }
                 temp= temp.next;
            }
             return true ; 
        }  
    /*  Node newnode = new Node('a') ; 
        Node new1 = new Node('b') ; 
        newnode.next = new1 ; 
        Node new2 = new Node('c') ; 
        newnode.next.next = new2 ; 
        Node new3 = new Node('b') ; 
        newnode.next.next.next = new3; 
        Node new4 = new Node('a') ; 
        newnode.next.next.next.next = new4; 
        newnode.next.next.next.next.next = null; 
System.out.println(isPallendrom(newnode));
 */

 // Q 2   SAMPLIFY PATH ; 
 
 public static String simplypath(String str) {
     String ans = "/";
     Stack<String> s = new Stack<>();
     for (int i = 0; i < str.length(); i++) {
         String dir = "";
         while (i < str.length() && str.charAt(i) != '/') {
             dir += str.charAt(i);
             i++;
         }
         if (dir.equals(".") || dir.isEmpty()) {
             continue;
         } else if (dir.equals("..")) {
             if (!s.isEmpty()) {
                 s.pop();
             }
         } else {
             s.push(dir);
         }
     }
     Stack<String> s1 = new Stack<>();
     while (!s.isEmpty()) {
         s1.push(s.pop());
     }
     while (!s1.isEmpty()) {
         ans += s1.pop();
     }
     return ans.isEmpty() ? "/" : ans;
 }
 
// Q3 code decone 
 
 public static void main(String[] args) {
       String str = "/a/b/a/./g/e/c/f/../s/d/r/" ; 
        System.out.println(simplypath(str));



     }
}
