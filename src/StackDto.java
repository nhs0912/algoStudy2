/**
 * Created by heeseoknoh on 06/10/2016.
 */
public class StackDto implements Stack {
    int top = 0;
    char[] stackText;
    char text;
    int size;

    StackDto() {

    }

    StackDto(int size) {
        this.size = size;
        stackText = new char[size];
    }


    @Override
    public void pop() {
        top--;
        System.out.println("pop 되었습니다.");
    }

    @Override
    public void push(char text) {
        this.text = text;
        stackText[top++] = text;
    }

    @Override
    public void display() {
        for (char text : stackText) {
            System.out.print(text + " ");
        }
        System.out.println();
    }


}
