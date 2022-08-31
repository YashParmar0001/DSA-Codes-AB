package com.company.StringAlgorithms.Part1;

public class StringsBasics {
    public static void main(String[] args) {
        String s1 = "Yash";
        String s2 = "Yash";
        String s3 = new String("Yash");

        // == operator compares references
        System.out.println(s1 == s2); // true
        System.out.println(s2 == s3); // false

        // .equals() compares values
        System.out.println(s1.equals(s2));
    }
}
