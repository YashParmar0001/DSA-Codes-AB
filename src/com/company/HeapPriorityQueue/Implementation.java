package com.company.HeapPriorityQueue;

public class Implementation {
    public static void main(String[] args) throws Exception {
        MinHeap heap = new MinHeap(8);
        heap.insert(5);
        heap.insert(10);
        heap.insert(15);
        heap.insert(12);
        heap.insert(14);
        heap.insert(2);
        heap.printHeap();
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

    public void printHeap() {
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
