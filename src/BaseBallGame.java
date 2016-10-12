import java.util.Scanner;

/**
 * Created by nhs09 on 2016-10-12.
 */
public class BaseBallGame {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int inputNum;
        int strike = 0;
        int ball = 0;
        String rightNumber = "";

        int[] Numbers = new int[3];


        for (int i = 0; i < Numbers.length; i++) {
            if (i == 0) {
                Numbers[i] = (int) (Math.random() * 1000) % 10; //첫번째 난수 입력
            } else {
                Numbers[i] = (int) (Math.random() * 1000) % 10;//두번째 세번째 난수 입력
                while (Numbers[i] == Numbers[i - 1]) {//두번째 숫자와 첫번째 숫자가 같으면 수행
                    Numbers[i] = (int) (Math.random() * 1000) % 10;
                }
                if (i == Numbers.length - 1) {//마지막 숫자는 두번째와 첫번째와 같은지 안같은지 확인한다.

                    while (Numbers[i] == Numbers[i - 1] || Numbers[i] == Numbers[i - 2]) {//맨 마지막 숫자가 첫번째와 두번째 숫자를 검사해서 같은 숫자가 있으면 수행
                        Numbers[i] = (int) (Math.random() * 1000) % 10;
                    }
                }

            }
        }
//        for (int a : Numbers) {//정답 먼저 보여주기
//            System.out.print(a);
//            rightNumber += a;
//        }
//        System.out.println();


        do {//strike가 3개가 아니면
            inputNum = sc.nextInt();
            int first = inputNum / 100;//백의 자리
            int mid = (inputNum % 100) / 10; //십의 자리
            int last = (inputNum % 100) % 10;//일의 자리
            if (first != mid && first != last && mid != last) {//서로 다른 숫자여야함
                for (int i = 0; i < Numbers.length; i++)//같은 숫자 index 검사
                {
                    if (first == Numbers[i]) {//숫자만 맞고
                        if (i == 0) {//첫번째 자리와 숫자가 같으면
                            strike++; //strike 1 증가
                        } else {
                            //숫자만 맞으면 ball 1 증가
                            ball++;
                        }
                    }
                    if (mid == Numbers[i]) {//십의 자리 숫자와 숫자가 같으면
                        if (i == 1) {
                            //두번째 자리와 숫자가 같으면
                            strike++;
                        } else {//숫자만 같으면
                            ball++;

                        }
                    }
                    if (last == Numbers[i]) {//세번째 자리숫자와 숫자가 같으면
                        if (i == 2) {//세번째 자리와 숫자가 같으면
                            strike++;
                        } else {
                            ball++;
                        }
                    }

                }
                if (strike == 3) {//3 strike면 while문 빠져나온다.
                    System.out.println("정답!");
                    System.out.println(rightNumber);
                    break;
                }else {
                    System.out.println("strike =" + strike);
                    System.out.println("ball = " + ball);
                }
            } else {
                System.out.println("같은 숫자를 입력했습니다.다시 입력하세요.");
            }


            strike = 0;//초기화
            ball = 0;//초기화

        } while (true);


    }
}
