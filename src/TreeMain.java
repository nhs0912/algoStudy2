import DataStructure.Heap;
import DataStructure.HeapSort;
import DataStructure.LinkedTree;
import DataStructure.TreeNode;

/**
 * Created by nhs09 on 2016-10-31.
 */


public class TreeMain {

    public static void main(String[] args) {
        //Tree tree= new ArrayBinaryTree(8);

        Heap heap = new HeapSort(8);
        LinkedTree T = new LinkedTree();
        TreeNode n7 = T.makeBT(null, 'D', null);
        TreeNode n6 = T.makeBT(null, 'C', null);
        TreeNode n5 = T.makeBT(null, 'C', null);
        TreeNode n4 = T.makeBT(null, 'A', null);
        TreeNode n3 = T.makeBT(n6, '/', n7);
        TreeNode n2 = T.makeBT(n4,'*',n5);
        TreeNode n1 = T.makeBT(n2,'-',n3);
        System.out.printf("\n Preorder : ");
        T.preorder(n1);


    }
}
