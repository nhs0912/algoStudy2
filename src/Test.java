

/**
 * Created by nhs09 on 2016-10-21.
 */


abstract class Human {
    int a = 0;
    String b = "인간";

    public void print() {
        System.out.println("인간");
    }
}

class Father extends Human {
    int a = 10;
    String b = "아빠";

    public void print() {
        System.out.println("아빠");
    }
}

class Mother extends Human {
    int a = 100;
    String b = "엄마";

    public void print() {
        System.out.println("엄마");
    }
}

class Son extends Father {

    int a = 20;
    String b = "아들";
    int c = 30;
    int d = 40;

    public void print() {
        System.out.println("아들");
    }
}

class Execute {
    public int FactorialExecute(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * FactorialExecute(n - 1);
        }
    }

    public int FactorialRecursion(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public void HanoiTop(int n, char from, char aux, char to) {
        if (n == 1) {
            System.out.println(n + "=" + from + "-> " + to);
            return;
        }
        HanoiTop(n - 1, from, to, aux);
        System.out.println(n + "=" + from + "-> " + to);

        HanoiTop(n - 1, aux, from, to);

    }

    int[] A = new int[3];

    public void Binary(int n) {
        if (n < 1) {
            for (int i = 0; i < A.length; i++) {
                System.out.print(A[i]);
            }
            System.out.println();
        } else {
            A[n - 1] = 0;
            Binary(n - 1);
            A[n - 1] = 1;
            Binary(n - 1);
        }


    }


}

class ListNode {
    private int data;
    public ListNode link;

    ListNode() {
        this.data = 0;
        this.link = null;
    }

    public ListNode(int data) {
        this.data = data;
        this.link = null;
    }

    public ListNode(int data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public int getData() {
        return this.data;
    }
}


class LinkedList2 {
    private ListNode head;

    public LinkedList2() {
        head = null;
    }

    public void insertMiddleNode(ListNode pre, int data) {
        ListNode newNode = new ListNode(data);
        newNode.link = pre.link;
        pre.link = newNode;
    }

    public void insertFirstNode(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            this.head = newNode;
        } else {
            //ListNode temp =head;
            newNode.link = head;
            head= newNode;
        }
    }

    public void print() {
        ListNode temp = this.head;
        System.out.print("(");
        while (temp != null) {
            System.out.print(temp.getData());
            temp = temp.link;
            if (temp != null) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }

}

public class Test {
    public static void main(String[] args) {
//

        LinkedList2 list = new LinkedList2();

        list.insertFirstNode(1);
        list.insertFirstNode(2);
         list.insertFirstNode(3);


        list.print();


    }
}
