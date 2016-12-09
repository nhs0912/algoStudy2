package DataStructure;

/**
 * Created by nhs09 on 2016-10-21.
 */
public interface Queue {
    boolean isEmpty();
    boolean isFull();
    void enQueue(char item);
    char deQueue();
    void delete();
    char peek();
}
