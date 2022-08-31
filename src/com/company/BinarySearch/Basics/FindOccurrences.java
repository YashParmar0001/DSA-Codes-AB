package com.company.BinarySearch.Basics;

public class FindOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 4, 4, 4, 5, 6, 6};
        System.out.println(findOccurrences(arr, 6));
    }

    static int findOccurrences(int[] arr, int target) {
        int leftOccurrence = FirstOccurenceOfElement.findFirstOccurrence(arr, target);
        int rightOccurrence = LastOccurrenceOfElement.findLastOccurrence(arr, target);

        return rightOccurrence - leftOccurrence + 1;
    }
}
