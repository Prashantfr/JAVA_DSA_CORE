package Stack_Queue;

class StackArray {
    int[] arr;
    int top;
    int size;

    StackArray(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    // Push
    void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    // Pop
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    // Peek
    int peek() {
        if (top == -1) return -1;
        return arr[top];
    }

    // isEmpty
    boolean isEmpty() {
        return top == -1;
    }
}