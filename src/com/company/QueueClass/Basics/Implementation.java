package com.company.QueueClass.Basics;

public class Implementation {
    public static void main(String[] args) throws Exception {
//        QueueUsingLL queue = new QueueUsingLL();
        QueueUsingCircularArray queue = new QueueUsingCircularArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

class QueueUsingLL {
    private Node front, rear;

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        }else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    int dequeue() throws Exception {
        if (isEmpty()) throw new Exception("Queue is Empty!");
        int data = front.data;
        front = front.next;
        return data;
    }

    int getFront() throws Exception {
        if (isEmpty()) throw new Exception("Queue is Empty!");
        return front.data;
    }

    boolean isEmpty() {
        return front == null;
    }
}

class QueueUsingArray {
    int front, rear;
    int[] arr;
    int capacity;
    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = rear = -1;
    }

    void enqueue(int data) throws Exception {
        if (isFull()) throw new Exception("Queue array is Full!");
        if (isEmpty()) {
            front = 0;
        }
        rear++;
        arr[rear] = data;
    }

    int dequeue() throws Exception {
        if (isEmpty()) throw new Exception("Queue is Empty!");
        int data = arr[front]; // front is always 0
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i+1];
        }
        rear--;
        return data;
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    boolean isEmpty() {
        return rear == -1;
    }
}

class QueueUsingCircularArray {
    private int front, rear;
    int[] arr;
    int capacity;

    public QueueUsingCircularArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = rear = -1;
    }

    void enqueue(int data) throws Exception {
        if (isFull()) throw new Exception("Queue is full!");
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
    }

    int dequeue() throws Exception {
        if (isEmpty()) throw new Exception("Queue is Empty!");
        if (front == rear) {
            int data = arr[front];
            front = rear = -1;
            return data;
        }
        int data = arr[front];
        front = (front + 1) % capacity;
        return data;
    }

    boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    boolean isEmpty() {
        return front == -1;
    }

    int size() {
        return isEmpty() ? 0 : (capacity - front + rear) % capacity + 1;
    }
}

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}
