package com.company.OOPSProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Inheritance {
    public static void main(String[] args) {
        Parent p1 = new Parent();
//        Child c1 = new Child(3);
//        Parent c2 = new Child(3); // Dynamic method dispatch
////        Child c3 = new Parent(); // Error
        p1.print();
//        c1.print();
//        System.out.println(c2.age);
//        Parent.method1();
    }
}

class Parent {
    int age;
    int skills;
    char c;

    public Parent() {
        System.out.println("This is parent class!");
    }

    public Parent(int age, int skills, char c) {
        this.age = age;
        this.c = c;
        this.skills = skills;
    }

    public Parent(int age, int skills) {
        this.age = age;
        this.skills = skills;
    }

    static void method1() {
        System.out.println("This is static method!");
    }

    void print() {
        System.out.println("This is parent class method!");
    }
}

class Child extends Parent {
    int candy;

    public Child(int age, int skills, char c, int candy) {
        super(age, skills);
        this.candy = candy;
    }

    void print() {
        System.out.println("This is child class method!");
    }
}
