package A;

import java.util.Scanner;

/**
 * 2.[필수문항] <문제에 대한 답변을 Word 파일형식으로 첨부하세요>
 * 1에서 n까지 숫자 중에 숫자 d가 몇 번 나오는지 숫자를 세는 프로그램을 작성하시오.
 * 예를 들어 1에서 10,000까지 중에 숫자 8은 4,000개가 나온다. (프로그램 언어는 무엇을 사용해도 상관없음)
 */

class NBP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int cnt = 0;//갯수
        int i = 1;//1부터 시작한다.
        while (n >= i) {
            int num = i;
            while (num > 0) {
                if (d == num % 10) {
                    cnt++;
                }
                num /= 10;
            }
            i++;
        }
        System.out.println(cnt);



    }
}