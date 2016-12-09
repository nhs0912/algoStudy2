import java.util.Scanner;

/**
 * Created by heeseoknoh on 02/10/2016.
 */


public class Main {
    public static void main(String[] args) {
        Stack stack; //stack
        int resultPair = 0; //마지막 결과 괄호 짝 번호를 위한 수

        Scanner sc = new Scanner(System.in);
        //System.out.println("샘플 갯수 입력 ");
        //int cnt = 2;
        int cnt = sc.nextInt(); //갯수 입력
        String[] inputTexts = new String[cnt]; //들어갈 괄호
        String[] priorityTexts = new String[cnt]; //우선순위 괄호
        int stackEmptyCheckNum = 0; //stack이 비어있을 경우 데이터 입력 갯수
        char popChar = 0; //stack에 pop 한 값 저장
        int popPriorityValue = 0; //pop한 괄호의 우선순위
        int changeRightPriorityValue = 0; //오른쪽 괄호의 우선 순위
        char rightParenthese = 0; //stack에 있는 오른쪽 괄호
        char changeRightParenthese = 0; //비교를 위해 오른쪽 괄호를 왼쪽 괄호로 변경
        char resultParenthese = 0; //우선순위 결과 괄호
        for (int i = 0; i < cnt; i++) { // 입력 받기
            String inputText = sc.next();
            String priorityText = sc.next();
            inputTexts[i] = inputText; //배열 안에 저장
            priorityTexts[i] = priorityText;
        }
//        for (int i = 0; i < inputTexts.length; i++) {//입력 된 것 보기
//            System.out.println(inputTexts[i] + " " + priorityTexts[i]);
//        }


        //  System.out.println("첫번 째 우선순위 괄호 갯수: " + priorityTexts[0].length());
        //System.out.println("우선순위1 :" + priorityTexts[0].charAt(0));
        //System.out.println("우선순위2 :" + priorityTexts[0].charAt(1));
        // System.out.println("우선순위3 :" + priorityTexts[0].charAt(2));

        for (int i = 0; i < inputTexts.length; i++) {
            //잘못 된 문자열 Stack으로 입력 받기
            //  System.out.println("입력 된 갯수 : " + inputTexts[i].length());
            stack = new StackDto(inputTexts[i].length()); //Stack 생성
            char[] resultTexts = new char[inputTexts[i].length()]; //결과 저장
            for (int j = 0; j < inputTexts[i].length(); j++) {
                // 입력된 괄호 Stack에 쌓기
                //왼쪽 괄호 일 때
                if (inputTexts[i].charAt(j) == '{' || inputTexts[i].charAt(j) == '(' || inputTexts[i].charAt(j) == '<'
                        || inputTexts[i].charAt(j) == '[') {
                    stack.push(inputTexts[i].charAt(j));
                } else {
                    //오른쪽 괄호를 만나면
                    // 스택에 있는 괄호와 우선순위를 따진다.
                    popChar = stack.pop(); //stack에 pop 한 값 저장
                    //     System.out.println("pop 한 값 : " + popChar);
                    //     System.out.println("top의 값 : " + stack.getTop());
                    if(stackEmptyCheckNum != 0) {
                        resultPair = stack.getTop() + stackEmptyCheckNum; //stack 의 top 값 저장
                    }
                    else
                    {
                        resultPair = stack.getTop() + 1;
                    }
                    popPriorityValue = 0; //pop한 괄호의 우선순위
                    changeRightPriorityValue = 0; //오른쪽 괄호의 우선 순위
                    rightParenthese = inputTexts[i].charAt(j); //stack에 있는 오른쪽 괄호
                    changeRightParenthese = 0; //비교를 위해 오른쪽 괄호를 왼쪽 괄호로 변경
                    //오른쪽 괄호를 왼쪽 괄호로 변경
                    switch (rightParenthese) {
                        case ')':
                            changeRightParenthese = '(';
                            break;
                        case '}':
                            changeRightParenthese = '{';
                            break;
                        case '>':
                            changeRightParenthese = '<';
                            break;
                        case ']':
                            changeRightParenthese = '[';
                            break;
                    }


                    if (popChar != changeRightParenthese) {//괄호가 서로 다를 때
                        //우선순위를 따진다.
                        for (int k = 0; k < priorityTexts[i].length(); k++) {
                            if (popChar == priorityTexts[i].charAt(k)) {//pop 한 괄호와 우선순위 괄호가 같을 때
                                popPriorityValue = k; //pop한 괄호의 우선순위
                            }
                            if (changeRightParenthese == priorityTexts[i].charAt(k)) {
                                changeRightPriorityValue = k;
                            }
                        }
                        if (popPriorityValue < changeRightPriorityValue) {//pop한 괄호가 더 우선순위 일 때 (왼쪽 괄호가 우선순위가 높을 때 )
                            resultParenthese = popChar;
                            switch (resultParenthese) {
                                case '{':
                                    rightParenthese = '}';
                                    break;
                                case '[':
                                    rightParenthese = ']';
                                    break;
                                case '(':
                                    rightParenthese = ')';
                                    break;
                                case '<':
                                    rightParenthese = '>';
                                    break;
                            }
                        } else if (popPriorityValue > changeRightPriorityValue)//오른쪽 괄호가 우선순위가 높을 때
                        {
                            resultParenthese = changeRightParenthese;
                        }

                        if (stack.getTop() !=-1) {
                            //stack이 비어있지 않을 경우
                            resultTexts[resultPair] = resultParenthese;
                            resultPair = (inputTexts[i].length() - 1) - resultPair;
                            resultTexts[resultPair] = rightParenthese;
                            //System.out.println(resultParenthese + "" + rightParenthese);
                        } else {//stack이 비어있을 경우
                            resultTexts[stackEmptyCheckNum++]= resultParenthese;
                            resultTexts[stackEmptyCheckNum++]=rightParenthese;

                        }
                    } else {
                        //괄호가 서로 같을 때

                        if(stack.getTop() !=-1) {
                            //stack이 비어있지 않을 때
                            resultTexts[resultPair] = popChar;
                            resultPair = (inputTexts[i].length() - 1) - resultPair;
                            resultTexts[resultPair] = rightParenthese;
                            //   System.out.println("같은 값");
                            //   System.out.println(popChar + "" + rightParenthese);
                        }
                        else{
                            //stack이 비어있을 때
                            resultTexts[stackEmptyCheckNum++]= popChar;
                            resultTexts[stackEmptyCheckNum++]= rightParenthese;

                        }
                    }
                }
                //   stack.display();
            }
            for (char c : resultTexts) {
                System.out.print(c);
            }
            System.out.println();
        }


    }
}
