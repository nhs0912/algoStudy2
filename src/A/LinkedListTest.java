package A;

import DataStructure.LinkedList;
import DataStructure.ListNode;

/**
 * Created by nhs09 on 2016-10-17.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList L= new LinkedList();
        System.out.println("1)공백 리스트에 노드 3개 삽입하기");
        L.insertLastNode("월");
        L.insertLastNode("화");
        L.insertLastNode("수");
        L.printList();

        System.out.println("중간에 추가하기 ");
        ListNode pre = L.searchNode("화");
        if(pre ==null)
        {
            System.out.println("검색 실패 ");
        }
        else{
            L.insertMiddleNode(pre,"목");
            L.printList();
        }


        System.out.println("역순으로 바꾸기 ");
        L.reverseList();
        L.printList();

        System.out.println("마지막 노드 삭제하기");
        L.deleteLastNode();
        L.printList();
    }
}
