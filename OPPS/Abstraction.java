//package OPPS;
//
//public class Abstraction {
//    public static void main(String[] args) {
//        // Horse h = new Horse();
//        // h.eat();
//        // h.walk();
//        // System.out.println(h.colour);
//
//        // Chicken c = new Chicken() ;
//        // c.eat();
//        // c.walk();
//
//        Mustang mus = new Mustang() ;
//    }
//}
//
//abstract class Animal {
//    String colour;
//
//    Animal() {
//        System.out.println("animal constructer called ");
//    }
//
//    void eat() {
//        System.out.println("Animal eat ");
//    }
//
//    // Abstract method ;
//    abstract void walk();
//}
//
//class Horse extends Animal {
//    Horse() {
//        System.out.println("Horse constructer called ");
//    }
//
//    void change() {
//        colour = "Black";
//    }
//    // void walk (){
//    // }
//
//    void walk() {
//        System.out.println(" walk on 4 lags");
//    }
//}
//
//class Mustang extends Horse {
//    Mustang() {
//        System.out.println("mustang constructer called ");
//    }
//}
//
//class Chicken extends Animal {
//    Chicken() {
//        System.out.println("Chicken constructer called ");
//
//    }
//
//    void walk() {
//        System.out.println("walk on 2 lags");
//    }
//}
