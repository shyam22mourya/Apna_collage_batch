package Bit.Strings;
public class ToUP {
    public static String Touppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String srt = "hi , i am shyam mourya";
        System.out.println(Touppercase(srt) );
    }
}
