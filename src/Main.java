import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txtNum = sc.nextLine();

        char[] txtChar = txtNum.toCharArray();

        int maxCnt = 0;
        int cnt = 0;
        int sixCnt = 0;
        int nineCnt = 0;
//        boolean checkSix = false;
//        boolean checkNine = false;
        if (txtChar.length > 1) {
            if (txtChar[txtChar.length - 1] == '6') {
//                checkSix = true;
                sixCnt++;
            }

            if (txtChar[txtChar.length - 1] == '9') {
//                checkNine = true;
                nineCnt++;
            }
            for (int i = 0; i < txtChar.length - 1; i++) {
                cnt = 1;
                if (txtChar[i] == '6') {
//                    checkSix = true;
                    sixCnt++;
                }

                if (txtChar[i] == '9') {
//                    checkNine = true;
                    nineCnt++;
                }

                for (int j = 1 + i; j < txtChar.length; j++) {
                    if (txtChar[i] == txtChar[j]) {
                        cnt++;
                    }
                }
                if (maxCnt < cnt) {
                    maxCnt = cnt;
                }
            }


            if (nineCnt == 0 && sixCnt == 0) {
                System.out.println(maxCnt);
            } else if (nineCnt == 4 && sixCnt == 0) {
                System.out.println(nineCnt - 2);
            } else if (nineCnt == 0 && sixCnt == 4) {
                System.out.println(sixCnt - 2);
            } else if (nineCnt >= 1 && sixCnt >= 1) {

                if (nineCnt > sixCnt) {
                    System.out.println(nineCnt + sixCnt - 1);
                } else if (nineCnt == sixCnt) {
                    System.out.println(maxCnt);
                } else if (nineCnt < sixCnt) {
                    System.out.println(sixCnt + nineCnt - 1);

                }

            } else if (sixCnt > 1 && nineCnt == 0) {
                if (sixCnt == 2) {
                    System.out.println(maxCnt);
                } else {
                    System.out.println(sixCnt - 1);
                }
            } else if (sixCnt == 0 && nineCnt > 1) {
                if (nineCnt == 2) {
                    System.out.println(maxCnt-1);
                } else {
                    System.out.println(nineCnt - 1);
                }
            } else if(sixCnt==1)
            {
                System.out.println(maxCnt);
            }
            else if(nineCnt==1)
            {
                System.out.println(maxCnt);
            }
        } else if (txtChar.length == 1) {
            System.out.println(1);
        }


    }

}

