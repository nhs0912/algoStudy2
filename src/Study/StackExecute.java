package Study;

import java.io.*;
import java.util.StringTokenizer;


class Stack {
    class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    boolean isEmpty() {
        return top == null;
    }

    int peek() {
        return top.data;
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    int top() {
        if (top == null) {
            return -1;
        }
        return top.data;
    }

    int size() {
        int cnt = 0;
        Node tmp = top;
        while (tmp != null) {
            tmp = tmp.next;
            cnt++;
        }
        return cnt;
    }

    int empty() {
        if (isEmpty()) {
            return 1;
        }
        return 0;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            int data = top.data;
            top = top.next;
            return data;
        }
    }

    public void display() {
        while (top != null) {
            System.out.println(top.data);
            top = top.next;
        }
    }

}

class StackExecute {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        Stack s = new Stack();//Stack 생성
        while (n > 0) {
            n--;
            st = new StringTokenizer(br.readLine().trim());
            String order = st.nextToken();
            int data = 0;
            if (st.hasMoreTokens()) {
                data = Integer.parseInt(st.nextToken());
            }
            switch (order) {
                case "push":
                    s.push(data);
                    break;
                case "pop":
                    System.out.println(s.pop());
                    break;
                case "size":
                    System.out.println(s.size());
                    break;
                case "empty":
                    System.out.println(s.empty());
                    break;
                case "top":
                    System.out.println(s.top());
                    break;
            }
        }
    }
}
