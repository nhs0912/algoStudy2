package Study;

/**
 * Created by nhs09 on 2017-01-07.
 */


class CircularQueue {
    class Node {
        private int data;
        private Node next;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    private Node rear;
    private Node front;

    boolean isEmpty() {
        return rear == null;
    }

    void enQueue(int data) {
        if (!isEmpty()) {
            Node newNode = new Node(data);
            //Node previousNode= rear;
            rear.next = newNode;
            rear = newNode;
            rear.next = front; //connect a previous Node

        } else {
            Node newNode = new Node(data);
            rear = newNode;
            front = newNode;
        }
    }

    int getSize() {
        Node tmp = front;
        int size = 0;
        if (rear != null) {
            size = 1;
            while (tmp != rear) {
                tmp = tmp.next;
                size++;
            }
        }
        return size;
    }

    int deQueue() {
        int data = 0;
        if (!isEmpty()) {
            data = front.data;
            front = front.next;
            return data;
        } else {
            return -1;
        }
    }


    void display() {
        int size = getSize();
        // System.out.println("size="+ size);
        while (size > 0) {
            size--;
            System.out.println(front.data);
            front = front.next;
        }
    }


}

public class LinkedCircularQueue {

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue();

        q.enQueue(10);
        q.enQueue(20);
        System.out.println(q.getSize());

        //  q.deQueue();
        q.display();
        System.out.println("delete");
        q.deQueue();
        q.display();
    }
}


