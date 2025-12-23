package OPPS;
// import OPPS.*;

public class Basic {
    public static void main(String args[]) {
        Sujal su = new Sujal();
        su.work();
        su.setget(16);
        su.age = 18;
        System.out.println(su.age);
        BankAccount myacc = new BankAccount();
        myacc.name = "shyam";
        myacc.setpassword("2431231");
        System.out.println(myacc.getpasseord());

        Sujal au = new BankAccount();
        int n = au.age;
        System.out.println(n);

        Pen p1 = new Pen();
        p1.setColr("Red");
        p1.setTip(12);

        System.out.println(p1.GetColor());
        System.out.println(p1.GetTip());
    }
}

class Pen {
    private String color;
    private int tip;

    void setColr(String newColor) {
        this.color = newColor;
    }

    void setTip(int newtip) {
        this.tip = newtip;
    }

    String GetColor() {
        return color;
    }

    int GetTip() {
        return tip;
    }
}

class Sujal {

    String name;
    int age;

    void work() {
        System.out.println(" I am eating goo on daily bases");
    }

    void pyar() {
        System.out.println(" me chanda se pyar karta hu ");
    }

    void setget(int newage) {
        age = newage;
    }
}

class BankAccount extends Sujal {
    public String name;
    private String password;

    void setpassword(String pwd) {
        password = pwd;
    }

    String getpasseord() {
        return password;
    }
}

class Student {
    String name;
    int age;
    float percentage;

    void calcPercentege(int phy, int chem, int math) {
        percentage = (phy + chem + math) / 2;
    }

    void info(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
 class  Parent {
private String propery ; 
private String Dna ;
}

class child extends Parent{ 
     void show(){
          
     }
}