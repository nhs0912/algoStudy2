package DataStructure;

/**
 * Created by nhs09 on 2016-10-25.
 */
public class ArrayBinaryTree implements Tree {
    int[] tree;


    public ArrayBinaryTree() {
        super();
    }

    public ArrayBinaryTree(int size) {
        tree = new int[size];
    }

    @Override
    public int searchEmptyNode() {
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void insert(int num) {
        if (searchEmptyNode() != 0) {
            tree[searchEmptyNode()] = num;
        } else {
            System.out.println("비어있는 공간이 없습니다.");
        }
    }

    @Override
    public void insertLeftChild(int parent, int num) {
        if (searchNode(parent) != 0) {
            tree[searchNode(parent) * 2] = num;
        }
    }

    @Override
    public void insertRightChild(int parent, int num) {
        if (searchNode(parent) != 0) {
            tree[searchNode(parent) * 2 +1] = num;
        }
    }

    @Override
    public int searchNode(int num) {

        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == num) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void delete(int num) {
        System.out.println(num + " 값 지우는 작업");
        if (searchNode(num) != 0) {
            tree[searchNode(num)] = 0;
        } else {
            System.out.println("결과: " + num + " 값이 없습니다.");
        }
    }

    @Override
    public void lastDetele() {

    }

    @Override
    public void print() {
        for (int i = 1; i < tree.length; i++) {
            System.out.print(tree[i] + " ");

        }
        System.out.println();
    }
}
