package com.company.HeapPriorityQueue.Part1;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {2, 9, 4, 7, 1, 6, 8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int[] arr) throws Exception {
        MinHeap heap = new MinHeap(arr);
        for (int i = 0; i < heap.size(); i++) {
            arr[i] = heap.extractMin();
        }
    }
}

class MinHeap {
    private final int[] arr;
    private final int capacity;
    private int n;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity+1];
        n = 0;
    }

    public MinHeap(int[] arr) {
        this.arr = new int[arr.length+1];
        // Because of 1 based indexing
        System.arraycopy(arr, 0, this.arr, 1, this.arr.length - 1);
        this.capacity = arr.length;
        this.n = capacity;
        buildHeap();
    }

    int size() {
        return capacity;
    }

    private void swap(int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public void insert(int key) throws Exception {
        if (n == capacity - 1) throw new Exception("Heap is Full!");

        n = n + 1;
        arr[n] = key;

        int i = n;
        while (i > 1) {
            int parent = i/2;
            if (arr[parent] > arr[i]) {
                swap(parent, i);
                i = parent;
            }else return;
        }
    }

    int extractMin() throws Exception {
        if (n == 0) throw new Exception("Heap is Empty!");

        int result = arr[1];
        arr[1] = arr[n];
        n--;
        int i = 1;
        while (i <= n) {
            int left = 2 * i;
            int right = 2 * i + 1;

            int smallest = i;
            if (left <= n && arr[left] < arr[smallest]) {
                smallest = left;
            }
            if (right <= n && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != i) {
                swap(smallest, i);
                i = smallest;
            }else break;
        }
        return result;
    }

    void heapify(int i) {
        while (i <= n) {
            int left = 2 * i;
            int right = 2 * i + 1;

            int smallest = i;
            if (left <= n && arr[left] < arr[smallest]) {
                smallest = left;
            }
            if (right <= n && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != i) {
                swap(smallest, i);
                i = smallest;
            }else break;
        }
    }

    void buildHeap() {
        for (int i = n; i > 0; i--) {
            heapify(i);
        }
    }

    public void printHeap() {
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
