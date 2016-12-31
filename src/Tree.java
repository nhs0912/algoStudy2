//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
///**
// * Created by heeseoknoh on 16/12/2016.
// */
//
//class TreeNode {
//    int data = 0;
//    TreeNode left;
//    TreeNode right;
//}
//
//class BinarySearchTree {
//    private TreeNode root;
//    int[] result;
//    int index = 0;
//
//    BinarySearchTree(int size) {
//        result = new int[size];
//    }
//
//    public TreeNode insertKey(TreeNode root, int num) {
//        TreeNode p = root;
//        TreeNode newNode = new TreeNode();
//        newNode.data = num;
//        newNode.left = null;
//        newNode.right = null;
//        if (p == null) {
//            return newNode;
//        } else if (newNode.data < p.data) {
//            p.left = insertKey(p.left, num);
//            return p;
//        } else if (newNode.data > p.data) {
//            p.right = insertKey(p.right, num);
//            return p;
//        } else
//            return p;
//    }
//
//    public void insertBST(int num) {
//        root = insertKey(root, num);
//    }
//
//    public TreeNode searchBst(int num) {
//        TreeNode p = root;
//        while (p != null) {
//            if (num < p.data) {
//                p = p.left;
//            } else if (num > p.data) {
//                p = p.right;
//            } else {
//                return p;
//            }
//        }
//        return p;
//    }
//
//
//    public void inorder(TreeNode root) {
//        if (root != null) {
//            inorder(root.left);
//            result[index++] = root.data;
//            System.out.print(root.data + " ");
//            inorder(root.right);
//        }
//    }
//
//    public int[] orderArr() {
//        inorder(root);
//        return result;
//    }
//
//    public void print() {
//        inorder(root);
//        System.out.println();
//    }
//
//
//}
//
//
//public class Tree {
//
//    public static void main(String[] args) throws IOException {
//        int[] num = new int[1000];
//        BinarySearchTree bst = new BinarySearchTree(num.length);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        int index = 0;
////        while ((str = br.readLine()) != null) {
////            int number = Integer.parseInt(str);
////            num[index++] = number;
////        }
//        for (int i = 0; i < num.length; i++) {
////            if (num[i] == 0) {
////                break;
////            }
//
//            //bst.insertBST(num[i]);
//            bst.insertBST(Integer.parseInt(br.readLine()));
//        }
//        bst.print();
//
//    }
//}
