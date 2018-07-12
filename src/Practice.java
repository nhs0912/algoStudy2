//import java.io.IOException;
//import java.util.Scanner;
//
//class Stack {
//    private int size = 0;
//    private char[] datas;
//    int top = -1;
//    boolean check = true;
//
//    Stack(int size) {
//        this.size = size;
//        datas = new char[size];
//    }
//
//    boolean isEmpty() {
//        return top == -1;
//    }
//
//    boolean isFull() {
//        return top == datas.length - 1;
//    }
//
//    void push(char data) {
//        if (!isFull()) {
//            datas[++top] = data;
//        } else {
//            //System.out.println("가득찼습니다.");
//        }
//    }
//
//    char pop() {
//        if (!isEmpty()) {
//            return datas[top--];
//        } else {
//            //System.out.println("스택에 데이터가 없습니다.");
//            check = false;
//            return 0;
//        }
//    }
//
//    char peek() {
//        if (!isEmpty()) {
//            return datas[top];
//        } else {
//            System.out.println("스택에 데이터가 없습니다.");
//            return 0;
//        }
//    }
//
//    int getSize() {
//        return size;
//    }
//
//    int getTop() {
//        return top;
//    }
//
//    boolean getCheck() {
//        return check;
//    }
//
//    public int size() {
//    }
//}
//
//public class Practice {
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int d = sc.nextInt();
//        int num = n / 10;//각각의 자릿수 d의 갯수
//        int cipher = 0;
//        while (n > 9) {//입력된 n 값의 자릿수보다 -1 작기 때문에
//            cipher++;
//            n /= 10;
//        }
//        if (n != d) {
//            System.out.println(cipher * num);
//        } else {
//            //d=n 의 경우에는 +1 해준다.
//            System.out.println(cipher * num + 1);
//        }
//    }
//}
