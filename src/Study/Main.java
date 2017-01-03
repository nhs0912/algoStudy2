package Study;

/**
 * Created by heeseoknoh on 01/01/2017.
 */

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    int[] numbers; //입력된 숫자
    int[] countArr;//숫자 세기
    int[] result; //정렬된 후 숫자 저장
    int max = 0;
    int index = 0;
    int n = 0;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void inputNumbers() throws IOException {//숫자 입력하기
        //Scanner sc = new Scanner(System.in);
        //int size = sc.nextInt();
        int size;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
            if (max < num) {
                max = num;
            }
        }
    }

    void display(int[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            bw.write(arr[i] + "\n");
        }
        //System.out.println();
    }

    void sort() throws IOException {
        inputNumbers();
        int maxNumber = max;
        countArr = new int[maxNumber + 1]; //0-maxNumber+1만큼 생성
        // result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            //해당하는 숫자 카운터
            countArr[numbers[i]]++;
        }


//        for (int i = 1; i < countArr.length; i++) {
//            //누적 숫자 더하기
//            countArr[i] += countArr[i - 1];
//        }


//        for (int i = numbers.length - 1; i >= 0; i--) {
//            //정렬하기
//            result[--countArr[numbers[i]]] = numbers[i];
//            //countArr[numbers[i]]--;
//        }


        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                index++;
                if (index == n) {
                    System.out.println(i);
                }
                //bw.write(i);
            }
        }
        //bw.close();
        // display(numbers);
    }


    public static void main(String[] args) throws IOException {
        new Main().sort();


    }
}