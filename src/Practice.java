import java.io.IOException;
import java.util.Scanner;


public class Practice {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int num = n / 10;//각각의 자릿수 d의 갯수
        int cipher = 0;
        while (n > 9) {//입력된 n 값의 자릿수보다 -1 작기 때문에
            cipher++;
            n /= 10;
        }
        if (n != d) {
            System.out.println(cipher * num);
        } else {
            //d=n 의 경우에는 +1 해준다.
            System.out.println(cipher * num + 1);
        }
    }
}
