package A;

import java.util.Scanner;


class Sosu {
    //소수
    int inputNum = 0;

    Sosu() {

    }

    Sosu(int inputNum) {
        this.inputNum = inputNum;

    }


    int[] getSosuNum() {
        int[] numbers;
        int index = 0;
        int numbers_size = 0;
        for (int i = 2; i <= inputNum; i++) {//소수 숫자 구하기
            for (int j = 2; j <= i; j++) {//소수 판별
                if (i % j == 0) {
                    if (i == j) {
                        numbers_size++; //소수 갯수 구하기
                    } else {
                        //1과 자기자신 외에 나누어지기 때문에
                        break;
                    }
                }
            }
        }

        numbers = new int[numbers_size]; //numbers_size 결정

        for (int i = 2; i <= inputNum; i++) {//소수 숫자 구하기
            for (int j = 2; j <= i; j++) {//소수 판별
                if (i % j == 0) {
                    if (i == j) {
                        numbers[index++] = i;
                    } else {
                        //1과 자기자신 외에 나누어지기 때문에
                        break;
                    }
                }
            }
        }


        return numbers;
    }


}


public class Main2{

    static int factorial(int inputNum) {

        if (inputNum == 1) {
            return inputNum;
        } else {
            return inputNum * factorial(inputNum - 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int input = sc.nextInt();
        int input2 = 4;
        System.out.println(input2 + "!");
        input2 = factorial(input2);
        int input3 = input2;
        int resultInput = input2;
        //System.out.println("숫자를 입력해주세요.");
        //System.out.println(input);

        Sosu sosu = new Sosu(input2);
        int[] numbers = sosu.getSosuNum();
        System.out.println(input2 + "의 소수들");
        for (int num = 0; num < numbers.length; num++) {
            if (numbers.length == 1) {//소수가 하나 밖에 없으면
                System.out.println(numbers[num]);
            } else {
                if (num == numbers.length - 1) {//마지막에 , 제거
                    System.out.println(numbers[num]);
                } else {
                    System.out.print(numbers[num] + ",");
                }
            }
        }
        int count = 0;
        for (int i = 0; i < numbers.length; ) {//소수로 차례대로 나누기

            if (input2 % numbers[i] == 0) {
                //나누어서 몫이 1이 아니면
                //나누어서 나머지가 0이면 count 1 증가
                // 배열의 크기를 구해야하기 때문에 필요함
                count++;
                input2 = input2 / numbers[i];

                if (input2 / numbers[i] == 1) {
                    count++;
                    break;
                }
            } else {
                i++;
            }
        }
        //  System.out.println();
        System.out.println("count 갯수 : " + count);

        int[] resultNum = new int[count];
        //소수로 차례대로 나누기
        count = 0; //초기화

        for (int i = 0; i < numbers.length; ) {//소수로 차례대로 나누기

            if (input3 % numbers[i] == 0) {
                //나누어서 몫이 1이 아니면
                //나누어서 나머지가 0이면 count 1 증가
                // 배열의 크기를 구해야하기 때문에 필요함
                resultNum[count++] = numbers[i]; //소인수 분해 저장
                input3 = input3 / numbers[i];


                if (input3 / numbers[i] == 1 && input3 % numbers[i] == 0) {
                    resultNum[count++] = numbers[i]; //소인수 분해 저장
                    break;
                }
            } else {
                i++;
            }
        }


        System.out.println("소인수 분해 ");
        System.out.println("count = " + count);
        for (int num2 : resultNum) {
            System.out.print(num2 + ", ");

        }
        System.out.println();
        System.out.println("마지막 배열 ");

        //숫자 다른것 갯수 찾기

        int[] numCount = new int[resultNum.length]; //소수
        int[] numCountSquare = new int[resultNum.length];//제곱 숫자 갯수

        int temp = 0;
        for (int i = 0; i < resultNum.length; i++) {
            int countNum = 0;
            int searchNum = resultNum[i];
            numCount[temp] = searchNum;

            for (int j = 0; j < resultNum.length; j++) {
                if (resultNum[j] == searchNum) {
                    countNum++;
                } else {
                    numCountSquare[temp++] = countNum;
                    if(j !=resultNum.length) {
                        i = j;
                    }else
                    {
                        break;
                    }
                }


            }

        }
        //소수와 소수 갯수 배열에 넣기
       // count = 0;

        for (int i = 0; i < numCount.length; i++) {
            System.out.print(numCount[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < numCountSquare.length; i++) {
            System.out.print(numCountSquare[i] + " ");
        }


//        int countSosu = 1;
//        for (int i = 0; i < resultNum.length; i++) {
//
//            if (i != resultNum.length - 1) {//마지막은 실행하지 않는다.
//                numCount[count * 2] = resultNum[i];//소수 입력
//                if (resultNum[i] == resultNum[i + 1]) {
//                    //현재와 현대 다음 값이 같으면
//                    countSosu++;
//                    numCount[(count * 2) + 1] = countSosu;
//                } else {
//                    //같지 않으면 다른 숫자이기 때문에 resultNum에 추가한다.
//                    countSosu = 1;
//                    numCount[(i * 2) + 1] = countSosu;
//                    count++;
//                }
//            } else {//마지막에 남은 숫자 하나이면
//
//                numCount[i] = resultNum[i];
//                //numCount[i+1] = 1;
//
//            }
//
//
//        }
//
//
//        System.out.println("result :");
//
//        System.out.print(resultInput + "=");
//        for (int i = 0; i < numCount.length; i++) {
//            if (i % 2 == 0) {//짝수 번째 이면
//                System.out.print(numCount[i] + "^");
//            } else {
//                //홀수 번째 이면
//                if (i != numCount.length - 1) {
//                    System.out.print(numCount[i] + " X ");
//                } else {
//                    System.out.print(numCount[i]);
//                }
//            }
//        }
//        System.out.println();

        // 1) 입력 된 수 안에 소수를 구하기
        // 2) 소수 차례대로 나누기 하기
        // 3) 몫이 1이 될때까지 하기
        // 4) 배열이든 리스트든 넣어서 2^3*4^5 이런 식으로 출력하기

        //소수 구하기


    }
}