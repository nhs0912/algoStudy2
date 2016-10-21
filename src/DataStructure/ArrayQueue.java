package DataStructure;

/**
 * Created by nhs09 on 2016-10-21.
 */
public class ArrayQueue implements Queue {
    private int front;
    private int rear;
    private int queueSize;
    private char itemArray[];

    @Override
    public boolean isFull() {
        return (rear == this.queueSize - 1);
    }

    public ArrayQueue(int queueSize) {
        front = -1;
        rear = -1;
        this.queueSize = queueSize;
        itemArray = new char[this.queueSize];
    }


    @Override
    public boolean isEmpty() {
        return (front == rear);
    }

    @Override
    public void enQueue(char item) {
        if (isFull()) {
            System.out.println("큐가 가득 찼습니다.");
        } else {
            itemArray[++rear] = item;
            System.out.println("'" + item + "'" + "을 넣었습니다.");
        }
    }


    @Override
    public char deQueue() {
        if (isEmpty()) {
            System.out.println("삭제 오류");
            return 0;
        } else {
            return itemArray[++front];
        }
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("삭제 오류");

        } else {
            ++front;
        }
    }


    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("peek 오류");
            return 0;
        } else {
            return itemArray[front + 1];
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("큐가 비었습니다.");
        } else {
            System.out.printf("Array Queue>>");
            for (int i = front + 1; i <= rear; i++) {
                System.out.printf("%c", itemArray[i]);
            }
            System.out.println();
        }
    }
}
