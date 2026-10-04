package Stack_Queue;

class QueueArray {
    int[] arr;
    int front, rear, size;

    QueueArray(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
    }

    // Enqueue
    void enqueue(int x) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        arr[++rear] = x;
    }

    // Dequeue
    int dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return arr[front++];
    }

    // Peek
    int peek() {
        if (front > rear) return -1;
        return arr[front];
    }

    // isEmpty
    boolean isEmpty() {
        return front > rear;
    }
}