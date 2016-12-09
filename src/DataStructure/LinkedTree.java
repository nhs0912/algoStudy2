package DataStructure;

/**
 * Created by heeseoknoh on 03/11/2016.
 */
public class LinkedTree implements Tree {
    private TreeNode root;

    public TreeNode makeBT(TreeNode bt1, char data, TreeNode bt2) {
        TreeNode root = new TreeNode();
        root.data = data;
        root.left = bt1;
        root.right = bt2;
        return root;
    }

    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.printf("%c", root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            preorder(root.left);
            System.out.printf("%c", root.data);
            preorder(root.right);
        }
    }

    public void postorder(TreeNode root) {
        if (root != null) {
            preorder(root.left);
            postorder(root.right);
            System.out.printf("%c", root.data);
        }
    }




    @Override
    public int searchEmptyNode() {
        return 0;
    }

    @Override
    public int searchNode(int num) {
        return 0;
    }

    @Override
    public void insertLeftChild(int parent, int num) {

    }

    @Override
    public void insertRightChild(int parent, int num) {

    }

    @Override
    public void insert(int num) {

    }

    @Override
    public void delete(int num) {

    }

    @Override
    public void lastDetele() {

    }

    @Override
    public void print() {

    }
}
