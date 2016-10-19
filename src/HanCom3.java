import java.io.*;
import java.util.Scanner;

/**
 * Created by heeseoknoh on 10/10/2016.
 */
class minNum {
    void Execute(int x) throws FileNotFoundException {
        //       File file = new File("output.txt");


        Integer number = 0;
        int n = 1; // 수식 갯수

        int finalResult = 0;
        while (true) { //반복문
            String[] formulaArr = new String[n * 2];
            Integer cnt = 1;
            for (int i = 0; i < formulaArr.length; i++) {
                if (i % 2 == 0) {//짝수 자리에 * 넣기
                    formulaArr[i] = "*";
                    //formula += '*';
                } else {//홀수 자리에 n값 넣기
                    formulaArr[i] = cnt.toString();
                    cnt++;
                    //formula += cnt++;
                }
            }


            int starCnt = 0; //별의 갯수
            for (int i = 0; i < formulaArr.length; i++) {//별 갯수 세기
                for (int j = 0; j < formulaArr[i].length(); j++) {
                    if (formulaArr[i].charAt(j) == '*') {
                        starCnt++;
                    }
                }

            }

            // System.out.println("star 갯수 : " + starCnt);

            int allcaseCnt = (int) Math.pow(2, starCnt); //모든 경우의 수
            String[] signs = new String[allcaseCnt];
            for (Integer i = 0; i < allcaseCnt; i++) {
                String binarySign = "";
                String signText = Integer.toBinaryString(i);
                if (signText.length() < starCnt) {//별의 갯수 보다 2진수 자릿수가 작으면 앞에 0을 붙인다.
                    int zeroCnt = signText.length();
                    while (zeroCnt < starCnt) {// 0으로 자릿수를 맞춘다.
                        binarySign += "0";
                        zeroCnt++;
                    }
                }
                binarySign += signText;
                signs[i] = binarySign;//2진수 넣기
            }


            for (int i = 0; i < signs.length; i++) {
                for (int j = 0; j < signs[i].length(); j++) {
                    //*을 signs 값으로 판단하여 0 = + ,  1 = - 로 치환
                    if (signs[i].charAt(j) == '0') {//0 ='+'
                        formulaArr[j * 2] = "+";
                    } else {
                        formulaArr[j * 2] = "-";
                    }
                }
                int result = 0;
                for (int b = 0; b < formulaArr.length; b++) {//부호에 따라 다음 숫자를 더해서 변수 result에 합한다.
                    if (b != formulaArr.length - 1) {
                        if (formulaArr[b] == "-") {
                            result += -1 * Integer.parseInt(formulaArr[b + 1]);
                        } else if (formulaArr[b] == "+") {
                            result += +1 * Integer.parseInt(formulaArr[b + 1]);
                        }
                    }
                }

                if (result == x) {
                    finalResult = n;
                    // System.out.println(n);
                    FileOutputStream fos = new FileOutputStream("output.txt", true);
                    BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
                   // PrintStream ps = new PrintStream(bos);
                   // System.setOut(ps);
                    // file로 출력
                    System.out.println(n);
                   // System.out.close();
                    break;
                }
            }
            //System.out.println("n= "+n);
            //x 와 더한 값이 일치하면 n을 출력하고 break;

            if (finalResult == n) {//n값을 찾았으면 while문 빠져나오기
               // System.out.println("다음 숫자");
                break;
            }

            n++; //n을 1씩 증가한다.

        }

    }
}

public class HanCom3 {
    public static void main(String[] args) throws IOException {
        // FileReader fr = new FileReader("input.txt");
        File file = new File("input.txt");
        FileInputStream fis = new FileInputStream(file);
        System.setIn(fis);
        Scanner sc = new Scanner(System.in);
        //FileInputStream fis = new FileInputStream("input.txt",true);
        //FileOutputStream fos = new FileOutputStream("redir_test.log", true);
        //BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
        //PrintStream ps = new PrintStream(bos);
        String s = "output.txt";
        File f = new File(s);
        f.delete();//이전 파일을 지우고 다시 생성한다.
        if (file.exists()) {
            BufferedReader inFile = new BufferedReader(new FileReader(file));
            String sLine = null;
            int firstCnt = 0;
            int cnt = 0;
            int[] test = null;
            int b = 0;
            while ((sLine = inFile.readLine()) != null && inFile.readLine()!="") {
                if (firstCnt == 0) {
                    cnt = Integer.parseInt(sLine);
                    // System.out.println(sLine);
                    //  System.out.println();
                    test = new int[cnt];
                    firstCnt++;
                } else {
                    test[b++] = Integer.parseInt(sLine);
                }
            }
            for (int i = 0; i < cnt; i++) {//입력된 갯수 만큼 실행
                minNum mi = new minNum();
                mi.Execute(test[i]);
            }
        }
    }
}
