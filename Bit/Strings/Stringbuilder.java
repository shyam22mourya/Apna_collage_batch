package Bit.Strings;
public class Stringbuilder {
    public Stringbuilder(String string) {
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
         StringBuilder sb = new StringBuilder(""); 
           for ( char ch = 'a'  ; ch <='z' ; ch++){
             sb.append(ch+" ");
           }
           System.out.println(sb.length());
    }

    public void append(char curr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'append'");
    }
}
