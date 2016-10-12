import java.util.Scanner;

interface Triangle {
    void drawTriangle(int lineNumber); //삼각형 그리기

    boolean Incomplete(int isDouble); //숫자 두개 그렸는지 안그렸는지 확인
}

class TriangleExecute implements Triangle {
    @Override
    public boolean Incomplete(int isDouble) {
        if (isDouble == 2) {//2개를 그렸다면
            return false;
        } else { //0개 또는 1개만 그렸다면
            return true;
        }
    }


    @Override
    public void drawTriangle(int lineNumber) {
        int width = (lineNumber * 2) - 1;// 삼각형 가로 길이
        int height = lineNumber; //삼각형 세로 길이
        int[][] lineArr = new int[height][width];
        int num = 0;
        int centerNumber = width / 2;
        int rightNum = centerNumber;
        int leftNum = centerNumber;
        boolean flag = true;
        int isDouble = 0;
        for (int i = 0; i < lineArr.length; i++) {
            isDouble = 0; //줄이 바뀌면 0으로 초기화
            for (int j = 0; j < lineArr[i].length; j++) {
                if (num > 9) {
                    //num이 10보다 커지면 0으로 초기화
                    num = 0;
                }
                if (i == 0 && j == centerNumber) {//맨처음 0
                    lineArr[i][j] = num++;
                    System.out.print(lineArr[i][j]);
                    rightNum++;
                    leftNum--;
                } else if (i != 0 && j == leftNum && Incomplete(isDouble)) {
                    //왼쪽 숫자 넣기
                    lineArr[i][j] = num++;
                    System.out.print(lineArr[i][j]);
                    leftNum--;
                    isDouble++;
                } else if (i == lineArr.length - 1) {//마지막 줄 표시하기
                    lineArr[i][j] = num++;
                    System.out.print(lineArr[i][j]);
                } else if (i != lineArr.length &&
                        i != 0 && j == rightNum && Incomplete(isDouble)) {
                    //마지막과 첫째 줄이 아닌 것 그리고 두개의 숫자가 쓰여지지 않았다면
                    //오른쪽 숫자 넣기
                    lineArr[i][j] = num++;
                    System.out.print(lineArr[i][j]);
                    rightNum++;
                    isDouble++;
                } else {
                    //조건에 만족하지 않는다면 빈칸 입력
                    System.out.print(" ");
                }
                if (lineArr[i].length - 1 == j) {
                    //마지막 줄 띄어쓰기
                    System.out.println();
                }

            }
        }


    }
}

public class HanCom1 {


    public static void main(String[] args) {
        //  System.out.println("삼각형 줄 수 입력 : ");
        Scanner sc = new Scanner(System.in);
        int lineNumber = sc.nextInt(); //줄 수 입력
        // int lineNumber=3; //삼각형의 줄 수
        Triangle triangle = new TriangleExecute();
        triangle.drawTriangle(lineNumber);

    }
}



