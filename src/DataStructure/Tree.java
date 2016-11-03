package DataStructure;

/**
 * Created by nhs09 on 2016-10-24.
 */
public interface Tree {
    int searchEmptyNode();

    int searchNode(int num);

    void insertLeftChild(int parent, int num);

    void insertRightChild(int parent, int num);

    void insert(int num);

    void delete(int num);

    void lastDetele();

    void print();
}
