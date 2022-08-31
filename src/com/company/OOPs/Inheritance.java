package com.company.OOPs;

public class Inheritance {
    public static void main(String[] args) {
        Parent  bhavy = new Parent();
        Child jay = new Child();
        bhavy.age = 54;
        jay.age = 34;
        jay.candy = 4;
//        System.out.println(bhavy.age);
        bhavy.walk();
        jay.walk();

    }
}

class Parent {
    int age, money;

    void walk() {
        System.out.println("Parent is walking!");
    }
}

class Child extends Parent {
    int candy;

    void walk() {
        System.out.println("Child is walking!");
    }
}
