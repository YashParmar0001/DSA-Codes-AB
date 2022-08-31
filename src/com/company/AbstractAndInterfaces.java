package com.company;

public class AbstractAndInterfaces {
    public static void main(String[] args) {
            Car tesla = new Car();
            Person yash = new Coder();
        }
    }

    abstract class Vehicle {
        int tyres;

        // At least one attribute is abstract
        abstract void start();
    }

    class Car extends Vehicle {
        @Override
        void start() {
            System.out.println("The car is starting...");
        }
    }

    interface Person {
        void walk();
    }

    interface Human {
        void learn();
    }

    class Coder implements Person, Human {
        @Override
        public void walk() {
            System.out.println("The coder is walking...");
        }

        @Override
        public void learn() {
            System.out.println("The coder is learning...");
        }
    }