import java.util.Scanner;

/**
 * Created by nhs09 on 2016-10-17.
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] results = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            int x = sc.nextInt(); //구하는 숫자 입력
            if (x < 0) { //구하는 숫자가 음수이면
                x = -x;
            }
            int n = 1;
            int total;
            while (true) {
                total = n * (n + 1) / 2;//1부터 n까지의 총합
                if (total >= x) {
                    break;
                }
                n++;
            }
            while (true) {
                if ((total - x) % 2 == 0) {//짝수이면 n의 값을 찾은 것
                    results[i] = n;
                    break;
                    //System.out.println(n);
                } else {
                    n++;//그 다음 수
                    total += n; //홀수 이면 그 다음 숫자를 더한다.
                }
            }
        }
        //결과 출력
        for (int a : results) {
            System.out.println(a);
        }
    }
}
