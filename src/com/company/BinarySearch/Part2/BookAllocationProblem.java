package com.company.BinarySearch.Part2;

public class BookAllocationProblem {
    public static void main(String[] args) {
//        int[] books = {3, 1, 4, 7, 2, 5, 2, 9};
        int[] books = {31, 14, 19, 75};
        System.out.println(allocateBooks(books, 12));
    }

    static int allocateBooks(int[] books, int students) {
        int left = 0, right = 0;
        for (int book : books) right += book;

        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (isSafe(books, students, mid)) {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    static boolean isSafe(int[] books, int students, int pages) {
        int currStudents = 1;
        int current = 0;
        for (int book : books) {
            if (book > pages) return false;
            current += book;
            if (current > pages) {
                currStudents++;
                current = book;
            }
        }
        return currStudents == students;
    }
}
