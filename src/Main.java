
/**
 * Created by nhs09 on 2018-06-03.
 */

class Node{
    Node node;
    String data;
    Node(){

    }
    Node(String data){
        this.data= data;
    }
}
interface myStack {
    boolean isEmpty();

    boolean isFull();

    void push(String data); // input a data

    void pop();
    void print();
}
class myStackImpl implements myStack {
    Node top;

    @Override
    public boolean isEmpty() {
        return top==null? true:false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void push(String data) {
        Node newNode = new Node(data);//input a new data
        if(top != null) {//이미 data가 있다면
            newNode.node = top;
            top = newNode;
        }else{//처음 data를 넣을 때
            top = newNode;
        }

    }

    @Override
    public void pop() {
        if(!isEmpty())
        {
            System.out.println(top.data);
            top=top.node;
        }
        else{
            System.out.println("Stack is Empty");
        }
    }

    @Override
    public void print(){
        Node printHead = top;
        while(printHead !=null){
            System.out.print(printHead.data+" --> " );
            printHead=printHead.node;
        }
        System.out.println();
    }
}


class Main {

    public static void main(String[] args) {
        myStack s = new myStackImpl();
        s.push("가");
        s.push("나");
        s.push("다");
        s.print();
        s.pop();
        s.pop();
        s.pop();
        s.pop();

    }
}