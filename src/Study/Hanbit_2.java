package Study;

import java.io.*;

class Hanbit_2 {

    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().trim());
        int[] fibonacciArr = Fibonacci(n); //피보나치 수열 저장
        for (int i = 1; i < fibonacciArr.length; i++) {//피보나치 수열 출력
            bw.write("fibonacci " + i + " = " + fibonacciArr[i] + "\n");
        }
        bw.close();
    }

    int[] Fibonacci(int n) {
        int[] numbers = new int[n + 1]; //피보나치 수 저장 배열
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 0; i + 2 != numbers.length; i++) {//피보나치 수열 만들기
            numbers[i + 2] = numbers[i] + numbers[i + 1];
        }
        return numbers;
    }

    public static void main(String[] args) throws IOException {
        new Hanbit_2().Solve();
    }
}