package Study;

/**
 * Created by nhs09 on 2017-01-07.
 */

class ArrCircularQueue {
    int[] queue;
    int front = 0;
    int rear = 0;
    int size = 0;

    ArrCircularQueue(int size) {
        this.size = size;
        queue = new int[size];

    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
        return ((rear + 1) % size == front);
    }

    void enQueue(int data) {
        if (!isFull()) {
            rear = (rear + 1) % size;
            queue[rear] = data;
        } else {
            System.out.println("queue is already full");
        }
    }

    int deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % size;
            return queue[front];
        } else {
            System.out.println("queue is already empty");
            return 0;
        }
    }
    void display() {
        if(!isEmpty()) {
            int tmp = front;
            while (tmp != rear) {
                tmp = (tmp + 1) % size;
                System.out.println(queue[tmp]);
            }
        }
        else{
            System.out.println("큐가 비어있습니다.");
        }
    }

}

public class ArrayCircularQueue {

    public static void main(String[] args) {
        ArrCircularQueue q = new ArrCircularQueue(4);
        q.enQueue(5);
        q.enQueue(4);
        q.enQueue(3);

       // System.out.println("dequeue");
       // System.out.println(q.deQueue());
       // q.enQueue(10);
        q.deQueue();
        q.deQueue();
        q.enQueue(2);
        q.display();


    }
}
