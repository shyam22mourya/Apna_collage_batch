package Revision;

import java.util.ArrayList;
import java.util.Stack;

public class StackImp {

    public  static void  stackProblem(int stock [] , int span []){
     Stack<Integer>  s= new Stack<>() ;
     s.push(0);
     span[0] =1 ;

     for(int i = 1; i<stock.length;i++){
           // findmax
         while (!s.isEmpty() && stock[i] > stock[s.peek()]){
             s.pop();
         }
         if(s.isEmpty()){
             span[i] = i+1;
         }else {
             int prevMax = s.peek();
              span[i] = i-prevMax;
         }
         s.push(i);
     }
    }

    public  static  int [] nextGreaterR(int arr []){
        int [] ans = new int [arr.length];
        Stack<Integer> s = new Stack<>() ;
        for(int i = arr.length-1; i>= 0 ; i--){
             // find next greater
            //untill we don't get greater element
            while(!s.isEmpty() && arr[i] >= arr[s.peek()] ){
                 s.pop();
            }

            if(s.isEmpty()){
                ans[i] = -1 ;
            }else{
                 ans[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return ans ;
    }
    public  static  int [] nextGreaterL(int arr []){
        int [] ans = new int [arr.length];
        Stack<Integer> s = new Stack<>() ;
        for(int i = 0 ; i<arr.length ; i++){
            // find next greater
            //untill we don't get greater element
            while(!s.isEmpty() && arr[i] >= arr[s.peek()] ){
                s.pop();
            }

            if(s.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] =s.peek();
            }
            s.push(i);
        }
        return ans ;
    }

    public static int[] nextSmallerR(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? arr.length : s.peek();
            s.push(i);
        }
        return ans;
    }

    public static int[] nextSmallerL(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        return ans;
    }

public static boolean validParantics(String str){
        Stack<Character> s = new Stack<>() ;
        for(char ch : str.toCharArray()){
             if(ch == '(' || ch =='{' || ch == '['){
                  s.push(ch);
             }else{
                  if(s.isEmpty()) return false ;

                  if( (s.peek() =='('&& ch == ')' )
                          || (s.peek() =='{'&& ch == '}' )
                          || (s.peek() =='['&& ch == ']' )){
                      s.pop();
                  }else{
                       return false ;
                  }
             }
        }
        return true ;
}

public  static  int maxHistogram(int arr []){
        int max = Integer.MIN_VALUE;
    int nsl[] = nextSmallerL(arr);
    int nsr[] = nextSmallerR(arr);

    for(int  i = 0 ; i<arr.length ; i++){
        int area = arr[i] * (nsr[i]-nsl[i]-1) ;
        max = Math.max(max ,area);
    }

         return max ;
}

    static void main() {
//   int stock[] = {6,8,1, 0 ,3};
//        int ngr[] = nextGreaterR(stock);
//        int ngl[] = nextGreaterL(stock);
//        int nsr[] = nextSmallerR(stock);
//        int nsl[] = nextSmallerL(stock);
//
//     for(int i :ngr){
//         System.out.print(i);
//     }
//        System.out.println();
//
//        for(int i :ngl){
//            System.out.print(i);
//        }
//        System.out.println();
//        for(int i :nsr){
//            System.out.print(i);
//        }
//        System.out.println();
//
//        for(int i :nsl){
//            System.out.print(i);
//        }
       int arr[] = {2,1,5, 6, 2,3};
        System.out.println(maxHistogram(arr));
    }
    public  static  void print(StackList st ){
        while (!st.isEmpty()) {
            int element = st.peek();
            System.out.print(element +"->");
            st.pop();
        }
        System.out.println("Null");

    }
    public  static  void pushAtEnd(int data , StackList st ){
        if(st.isEmpty()){
            st.push(data);
            return ;
        }
        int top = st.pop();
        pushAtEnd(data ,st);
        st.push(top);
    }
    public  static  void reverse(StackList st ){
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverse(st);
        pushAtEnd(top , st );
    }
    public  static  String reverseString(String str ){
        if(str == null || str.length() == 1 )
            return str;

        Stack<Character> st = new Stack<>();
        for(char ch : str.toCharArray()){
             st.push(ch);
        }
        StringBuilder sb= new StringBuilder();
        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        return  sb.toString();
    }
}

   class  StackList{
     class Node {
          int data ;
          Node next ;
          Node (int data){
               this.data = data ;
          }
     }

     Node head ;
     int size =0;
     public  int peek(){
          if(size == 0 ){
               return -1 ;
          }
          return head.data ;
     }
     public  int pop(){
          if(head == null){
               return Integer.MAX_VALUE;
          }
          size--;
          int val = head.data;
          head = head.next ;
           return val ;
     }
     public void  push (int data){
          Node newNode =new Node(data);
           if(head == null){
                head = newNode;
           }
           newNode.next = head ;
           head = newNode ;
           size++ ;
     }

     public  boolean  isEmpty(){
          return size == 0 ;
     }

   }

    class StackArray {
        static ArrayList<Integer> list = new ArrayList<>();

        //peek
        public int peek() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

        // pop
        public int pop() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(list.size() - 1);
        }

        //push
        public boolean push(int data) {
            return list.add(data);
        }

        // isEmpty
        public boolean isEmpty() {
            return list.isEmpty();
        }
    }



