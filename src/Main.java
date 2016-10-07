import java.util.Scanner;

/**
 * Created by heeseoknoh on 02/10/2016.
 */


public class Main {
    public static void main(String[] args) {
        Stack stack; //stack
        Scanner sc = new Scanner(System.in);
        System.out.println("샘플 갯수 입력 ");
        int cnt = sc.nextInt(); //갯수 입력
        String[] inputTexts = new String[cnt]; //들어갈 괄호
        String[] priorityTexts = new String[cnt]; //우선순위 괄호
        for (int i = 0; i < cnt; i++) { // 입력 받기
            String inputText = sc.next();
            String priorityText = sc.next();
            inputTexts[i] = inputText; //배열 안에 저장
            priorityTexts[i] = priorityText;
        }
        for (int i = 0; i < inputTexts.length; i++) {//입력 된 것 보기
            System.out.println(inputTexts[i] + " " + priorityTexts[i]);
        }
        System.out.println("첫번 째 우선순위 괄호 갯수: " + priorityTexts[0].length());
        //System.out.println("우선순위1 :" + priorityTexts[0].charAt(0));
        //System.out.println("우선순위2 :" + priorityTexts[0].charAt(1));
        // System.out.println("우선순위3 :" + priorityTexts[0].charAt(2));

        for (int i = 0; i < inputTexts.length; i++) {
            //잘못 된 문자열 Stack으로 입력 받기
            System.out.println("입력 된 갯수 : " + inputTexts[i].length());
            stack = new StackDto(inputTexts[i].length()); //Stack 생성
            for (int j = 0; j < inputTexts[i].length(); j++) {
                // 입력된 괄호 Stack에 쌓기
                // 오른쪽 괄호 일 때 pop 하기
                if(inputTexts[i].charAt(j)== '{' || inputTexts[i].charAt(j)=='(' ||inputTexts[i].charAt(j)=='<'
                        ||inputTexts[i].charAt(j)=='[') {
                    stack.push(inputTexts[i].charAt(j));
                }else{
                    
                }
            }
            stack.display();
        }

    }
}
