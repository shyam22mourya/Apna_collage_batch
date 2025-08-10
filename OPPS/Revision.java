package OPPS;

public class Revision {
    public static void main(String[] args) {
        Rohit r = new Rohit();
    }

}

class Aspirant {
    String name;
    int age;
    String req;
    String[] skill;

    Aspirant() {
        System.out.println("Construcor has been called...");
        skill = new String[3];
    }
    // Shallow copy constructor
    // Aspirant(Aspirant s1) {
    // this.age = s1.age;
    // this.name = s1.name;
    // this.skill = s1.skill;
    // this.req = s1.req;
    // }

    // Deep copy Constructor
    Aspirant(Aspirant s1) {
        skill = new String[3];
        this.age = s1.age;
        this.name = s1.name;
        this.req = s1.req;
        for (int i = 0; i < skill.length; i++) {
            this.skill[i] = s1.skill[i];
        }
    }

    Aspirant(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

abstract class Player {
    String name;
    int age;
    int run;

    abstract void run();

    Player() {
        System.out.println("Player constructor called ");
    }
}

class Cricketer extends Player {

    Cricketer() {

    }

    void run() {
        System.out.println("Cricketer is running ");
    }
}

class Rohit extends Cricketer {
    Rohit() {
        System.out.println("Rohit constructor called ");
    }
}