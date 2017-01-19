package Study;

import java.io.*;
import java.util.StringTokenizer;

class Hanbit_1 {

    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken()); //n값 입력
        int k = Integer.parseInt(st.nextToken()); //k값 입력

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                bw.write(i + "C" + j + " = " + Combination(i, j) + " "); //iCj 조합
                if (j == k) {
                    break;
                }
            }
            bw.write("\n");
        }
        bw.close();
    }

    int Combination(int n, int k) {
        //조합 값 구하기
        int result = Factorial(n) / (Factorial(k) * Factorial(n - k));
        return result;
    }

    int Factorial(int n) {
        //팩토리얼 구하기
        if (n == 1 || n == 0) {
            //0 or 1 입력시 1 리턴
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        new Hanbit_1().Solve();
    }
}