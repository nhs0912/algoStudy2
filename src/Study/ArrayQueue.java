package Study;

/**
 * Created by nhs09 on 2017-01-07.
 */

class ArrQueue {
    int[] queue;
    int front = -1;
    int rear = -1;

    ArrQueue(int size) {
        queue = new int[size];

    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
        return rear == queue.length - 1;
    }

    void enQueue(int data) {
        if (!isFull()) {
            queue[++rear] = data;
        } else {
            System.out.println("queue is already full");
        }
    }

    int deQueue() {
        if (!isEmpty()) {
            return queue[++front];
        } else {
            System.out.println("queue is already empty");
            return 0;
        }
    }

    void display() {
        for (int i = 0; i < queue.length; i++) {
            System.out.println(queue[i]);
        }
    }


}

public class ArrayQueue {
    public static void main(String[] args) {
        ArrQueue q = new ArrQueue(4);
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.display();
        q.enQueue(50);
        for(int i=0;i<4;i++)
        {
            System.out.println(q.deQueue());
        }
    }

}
