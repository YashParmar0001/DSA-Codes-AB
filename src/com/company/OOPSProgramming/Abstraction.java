package com.company.OOPSProgramming;

import java.util.*;

public class Abstraction {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
    }
}

abstract class Base {
    int var1;
    int var2;

    void method1() {
        System.out.println("This is method 1!");
    }

    public Base() {

    }

    abstract void method2();

    abstract void method3();
}

interface Int1 {
    int var1 = 0;
    int var2 = 0;

    void method1();
    void method2();
}

class NewClass implements Int1 {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}

class Child1 extends Base {

    @Override
    void method2() {
        System.out.println("This is method 2!");
    }

    @Override
    void method3() {
        System.out.println("This is method 3!");
    }
}
