package A;

import DataStructure.ArrayQueue;

/**
 * Created by nhs09 on 2016-10-21.
 */
public class QueueArrayTest {
    public static void main(String[] args) {
        int queueSize =3;
        char deletedItem;
        ArrayQueue Q = new ArrayQueue(queueSize);
        Q.enQueue('A');
        Q.printQueue();

        Q.enQueue('B');
        Q.printQueue();
        deletedItem=Q.deQueue();
        if(deletedItem !=0)
        {
            System.out.println("삭제 된 아이템 : "+deletedItem);

        }
        Q.printQueue();
    }

}
