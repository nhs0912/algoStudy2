/**
 * Created by heeseoknoh on 06/10/2016.
 */
public class StackDto implements Stack {
    int top = -1;
    char[] stackText;
    char text;
    int size;

    @Override
    public int getTop() {

        return top;
    }

    StackDto() {

    }

    StackDto(int size) {
        this.size = size;
        stackText = new char[size];
    }


    @Override
    public char pop() {
        //top--;
        //  System.out.println("pop 되었습니다.");
        if(isEmpty() != true) {//스택이 비어있지 않다면 pop 실행
            return stackText[top--];
        }
        else{
            System.out.println("stack이 이미 비어있습니다.");
            return 0;
        }
    }

    @Override
    public void push(char text) {
        this.text = text;
        stackText[++top] = text;
    }

    @Override
    public void display() {
        if (!isEmpty()) {
            for (int i = 0; i < top; i++) {
                System.out.print(stackText[i] + " ");
            }
            System.out.println();
        }
        else{
            System.out.println("스택이 비어있습니다.");
        }
    }

    @Override
    public int getSize() {

        return stackText.length;
    }

    @Override
    public boolean isEmpty() {
        if (top != -1) {
            return false;
        } else {
            // System.out.println("스택이 비어있습니다. ");
            return true;
        }
    }

    @Override
    public boolean isFull() {
        if (top == stackText.length - 1) {
            //  System.out.println("스택이 꽉 찼습니다.");
            return true;
        }
        else {
            System.out.println("stack이 Full 입니다.");
            return false;
        }
    }


}
