import DataStructure.BinarySearchTree;
import DataStructure.TreeNode;

/**
 * Created by nhs09 on 2016-10-31.
 */


public class TreeMain {

    public static void main(String[] args) {
        //Tree tree= new ArrayBinaryTree(8);
//
//        Heap heap = new HeapSort(8);
//        LinkedTree T = new LinkedTree();
//        TreeNode n8 = T.makeBT(null,'e',null);
//        TreeNode n7 = T.makeBT(null, 'D', null);
//        TreeNode n6 = T.makeBT(null, 'C', null);
//        TreeNode n5 = T.makeBT(null, 'B', null);
//        TreeNode n4 = T.makeBT(n8, 'A', null);
//        TreeNode n3 = T.makeBT(n6, '/', n7);
//        TreeNode n2 = T.makeBT(n4,'*',n5);
//        TreeNode n1 = T.makeBT(n2,'-',n3);
//        System.out.printf("\n Preorder : ");
//        T.preorder(n1);


        BinarySearchTree bst = new BinarySearchTree();
        bst.insertBST('G');
        bst.insertBST('I');
        bst.insertBST('H');
        bst.insertBST('D');
        bst.insertBST('B');
        bst.insertBST('M');
        bst.insertBST('N');
        bst.insertBST('A');
        bst.insertBST('J');
        bst.insertBST('E');
        bst.insertBST('Q');

        System.out.print("\nBinary Tree >>> ");
        bst.printBST();
        System.out.print("Is There \"A\" ? >>>");
        TreeNode p1 = bst.searchBST('A');
        if(p1!=null)
        {
            System.out.print("Searching Success! Searched Key : "+p1.data);

        }
        else{
            System.out.print("Searching fail!!\n");
        }

    }
}
