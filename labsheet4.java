import java.util.Scanner;

public class Main {

    // ================= STACK USING ARRAY =================

    static int stack[] = new int[5];
    static int top = -1;

    static void pushArray(int value) {
        if (top == 4) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            stack[top] = value;
            System.out.println(value + " pushed");
        }
    }

    static void popArray() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack[top] + " popped");
            top--;
        }
    }

    static void displayArrayStack() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements:");

            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }


    // ================= STACK USING LINKED LIST =================

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static StackNode stackTop = null;

    static void pushLinked(int value) {
        StackNode newNode = new StackNode(value);

        newNode.next = stackTop;
        stackTop = newNode;

        System.out.println(value + " pushed");
    }

    static void popLinked() {
        if (stackTop == null) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stackTop.data + " popped");
            stackTop = stackTop.next;
        }
    }

    static void displayLinkedStack() {
        if (stackTop == null) {
            System.out.println("Stack is empty");
        } else {
            StackNode temp = stackTop;

            System.out.println("Stack elements:");

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }


    // ================= QUEUE USING ARRAY =================

    static int queue[] = new int[5];
    static int front = -1;
    static int rear = -1;

    static void enqueueArray(int value) {

        if (rear == 4) {
            System.out.println("Queue Overflow");
        } else {

            if (front == -1) {
                front = 0;
            }

            rear++;
            queue[rear] = value;

            System.out.println(value + " inserted");
        }
    }

    static void dequeueArray() {

        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow");
        } else {

            System.out.println(queue[front] + " deleted");
            front++;

            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
    }

    static void displayArrayQueue() {

        if (front == -1) {
            System.out.println("Queue is empty");
        } else {

            System.out.println("Queue elements:");

            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }


    // ================= QUEUE USING LINKED LIST =================

    static class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static QueueNode queueFront = null;
    static QueueNode queueRear = null;

    static void enqueueLinked(int value) {

        QueueNode newNode = new QueueNode(value);

        if (queueRear == null) {
            queueFront = queueRear = newNode;
        } else {
            queueRear.next = newNode;
            queueRear = newNode;
        }

        System.out.println(value + " inserted");
    }

    static void dequeueLinked() {

        if (queueFront == null) {
            System.out.println("Queue Underflow");
        } else {

            System.out.println(queueFront.data + " deleted");

            queueFront = queueFront.next;

            if (queueFront == null) {
                queueRear = null;
            }
        }
    }

    static void displayLinkedQueue() {

        if (queueFront == null) {
            System.out.println("Queue is empty");
        } else {

            QueueNode temp = queueFront;

            System.out.println("Queue elements:");

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }


    // ================= MAIN =================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STACK AND QUEUE =====");
            System.out.println("1. Stack using Array");
            System.out.println("2. Stack using Linked List");
            System.out.println("3. Queue using Array");
            System.out.println("4. Queue using Linked List");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    while (true) {

                        System.out.println("\n--- Stack using Array ---");
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("3. Display");
                        System.out.println("4. Back");

                        System.out.print("Enter choice: ");
                        int ch = sc.nextInt();

                        if (ch == 1) {
                            System.out.print("Enter value: ");
                            pushArray(sc.nextInt());
                        } 
                        else if (ch == 2) {
                            popArray();
                        } 
                        else if (ch == 3) {
                            displayArrayStack();
                        } 
                        else if (ch == 4) {
                            break;
                        } 
                        else {
                            System.out.println("Invalid choice");
                        }
                    }

                    break;


                case 2:

                    while (true) {

                        System.out.println("\n--- Stack using Linked List ---");
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("3. Display");
                        System.out.println("4. Back");

                        System.out.print("Enter choice: ");
                        int ch = sc.nextInt();

                        if (ch == 1) {
                            System.out.print("Enter value: ");
                            pushLinked(sc.nextInt());
                        } 
                        else if (ch == 2) {
                            popLinked();
                        } 
                        else if (ch == 3) {
                            displayLinkedStack();
                        } 
                        else if (ch == 4) {
                            break;
                        } 
                        else {
                            System.out.println("Invalid choice");
                        }
                    }

                    break;


                case 3:

                    while (true) {

                        System.out.println("\n--- Queue using Array ---");
                        System.out.println("1. Enqueue");
                        System.out.println("2. Dequeue");
                        System.out.println("3. Display");
                        System.out.println("4. Back");

                        System.out.print("Enter choice: ");
                        int ch = sc.nextInt();

                        if (ch == 1) {
                            System.out.print("Enter value: ");
                            enqueueArray(sc.nextInt());
                        } 
                        else if (ch == 2) {
                            dequeueArray();
                        } 
                        else if (ch == 3) {
                            displayArrayQueue();
                        } 
                        else if (ch == 4) {
                            break;
                        } 
                        else {
                            System.out.println("Invalid choice");
                        }
                    }

                    break;


                case 4:

                    while (true) {

                        System.out.println("\n--- Queue using Linked List ---");
                        System.out.println("1. Enqueue");
                        System.out.println("2. Dequeue");
                        System.out.println("3. Display");
                        System.out.println("4. Back");

                        System.out.print("Enter choice: ");
                        int ch = sc.nextInt();

                        if (ch == 1) {
                            System.out.print("Enter value: ");
                            enqueueLinked(sc.nextInt());
                        } 
                        else if (ch == 2) {
                            dequeueLinked();
                        } 
                        else if (ch == 3) {
                            displayLinkedQueue();
                        } 
                        else if (ch == 4) {
                            break;
                        } 
                        else {
                            System.out.println("Invalid choice");
                        }
                    }

                    break;


                case 5:
                    System.out.println("Program ended.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}