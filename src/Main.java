import java.util.ArrayList;
import java.util.Scanner;


interface Stack {

    char pop();// pop 하기

    void push(char text);

    void display(); //출력 하기

    int getSize(); //stack size

    boolean isEmpty(); // Stack이 비어있는지 검사

    boolean isFull(); //Stack이 꽉 찼는지 검사

    int getTop(); //현재 top 값 구하기

    //public boolean isFirstPop(); //오른쪽 괄호 만나서 처음으로 pop했는지 검사
}

class StackDto implements Stack {
    int top = -1;
    char[] stackText;
    char text;
    int size;
    boolean isFirstPop = true;
    boolean isSingle = true;

    @Override
    public int getTop() {

        return top;
    }

    boolean isSingle() {
        return isSingle;
    }

    void setSingle(boolean single) {
        isSingle = single;
    }

    StackDto(int size) {
        this.size = size;
        stackText = new char[size];
    }

    boolean isFirstPop() {
        return isFirstPop;
    }

    void setFirstPop(boolean firstPop) {
        isFirstPop = firstPop;
    }

    @Override
    public char pop() {
        //top--;
        //  System.out.println("pop 되었습니다.");
        if (isEmpty() != true) {//스택이 비어있지 않다면 pop 실행
            return stackText[top--];
        } else {
            System.out.println("stack이 이미 비어있습니다.");
            return 0;
        }
    }

    @Override
    public void push(char text) {
        this.text = text;
        stackText[++top] = text;
    }

    @Override
    public void display() {
        if (!isEmpty()) {
            for (int i = 0; i < top; i++) {
                System.out.print(stackText[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("스택이 비어있습니다.");
        }
    }

    @Override
    public int getSize() {

        return stackText.length;
    }

    @Override
    public boolean isEmpty() {
        if (top != -1) {
            return false;
        } else {
            // System.out.println("스택이 비어있습니다. ");

            return true;
        }
    }

    @Override
    public boolean isFull() {
        if (top == stackText.length - 1) {
            //  System.out.println("스택이 꽉 찼습니다.");
            return true;
        } else {
            System.out.println("stack이 Full 입니다.");
            return false;
        }
    }


}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //System.out.println("샘플 갯수 입력 ");
        //int cnt = 2;
        int cnt = sc.nextInt(); //갯수 입력
        // int cnt = 3;

        StackDto stack; //stack
        int resultPair = 0; //마지막 결과 괄호 짝 번호를 위한 수
        ArrayList<String> finalResultList = new ArrayList<>();
        String[] inputTexts = new String[cnt]; //들어갈 괄호
        String[] priorityTexts = new String[cnt]; //우선순위 괄호
        int stackEmptyCheckNum = 0; //고쳐진 괄호가 들어갈 자리 index 값
        char popChar = 0; //stack에 pop 한 값 저장
        int popPriorityValue = 0; //pop한 괄호의 우선순위
        int changeRightPriorityValue = 0; //오른쪽 괄호의 우선 순위
        char rightParenthese = 0; //stack에 있는 오른쪽 괄호
        char changeRightParenthese = 0; //비교를 위해 오른쪽 괄호를 왼쪽 괄호로 변경
        char resultParenthese = 0; //우선순위 결과 괄호
        int whereRightParenthese = 0;
        for (int i = 0; i < cnt; i++) { // 입력 받기
            String inputText = sc.next();
            String priorityText = sc.next();
            inputTexts[i] = inputText; //배열 안에 저장
            priorityTexts[i] = priorityText;
        }

//        inputTexts[0] = "(>{(>>";
//        priorityTexts[0] = "({<[";

//        inputTexts[0] = "{(>>(>";
//        priorityTexts[0] = "({<[";
//        inputTexts[1] = "<>";
//        priorityTexts[1] = "({<[";
//
//        inputTexts[2] = "<}<)({<}]>";
//        priorityTexts[2] = "({<[";
//        for (int i = 0; i < inputTexts.length; i++) {//입력 된 것 보기
//            System.out.println(inputTexts[i] + " " + priorityTexts[i]);
//        }


        for (int i = 0; i < inputTexts.length; i++) {
            //inputText 갯수 만큼 수행
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
                    if (stack.getTop() == 0) {
                        stack.setSingle(true);
                    }
                    if (stack.getTop() > 0) {
                        stack.setSingle(false);
                    }
                } else {
                    //오른쪽 괄호를 만나면
                    // 스택에 있는 괄호와 우선순위를 따진다.

                    //다중 괄호가 있으면 새로 바뀐 괄호를 저장할 위치를 고른다.
                    if (stack.isEmpty() != true) {
                        //스택이 비어있지 않다면
                        resultPair = stack.getTop() + stackEmptyCheckNum; //stack 의 top 값 저장
                    } else {//스택이 비어있다면
                        resultPair = stack.getTop() + 1 + stackEmptyCheckNum;
                    }

                    // resultPair=stack.getTop()+stackEmptyCheckNum;
                    if (stack.isFirstPop() && stack.isSingle() != true) {

                        whereRightParenthese = resultPair * 2 + 1;

                        stack.setFirstPop(false);
                    }
//                    else if(stack.isSingle()==true)
//                    {
//                        resultPair= stackEmptyCheckNum;
//                    }

                    // whereRightParenthese = stack.getTop();
                    popChar = stack.pop(); //stack에 pop 한 값 저장
                    //     System.out.println("pop 한 값 : " + popChar);
                    //     System.out.println("top의 값 : " + stack.getTop());

                    popPriorityValue = 0; //pop한 괄호의 우선순위
                    changeRightPriorityValue = 0; //오른쪽 괄호의 우선 순위
                    rightParenthese = inputTexts[i].charAt(j); //stack에 있는 오른쪽 괄호

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

                    //괄호 비교 후 변경된 오른쪽 괄호를 우선순위에 맞는 왼쪽 괄호로 변경
                    // if (popChar != changeRightParenthese) {//괄호가 서로 다를 때
                    //우선순위를 따진다.

                    for (int k = 0; k < priorityTexts[i].length(); k++) {
                        if (popChar == priorityTexts[i].charAt(k)) {//pop 한 괄호와 우선순위 괄호가 같을 때
                            popPriorityValue = k; //pop한 괄호의 우선순위
                        }
                        if (changeRightParenthese == priorityTexts[i].charAt(k)) {
                            changeRightPriorityValue = k;
                        }
                    }
                    if (popPriorityValue < changeRightPriorityValue) {//pop한 괄호(왼쪽괄호)가  우선순위 가 높을 때
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
                    {//왼쪽괄호를 오른쪽 괄호 형태로 바꿔준다.
                        resultParenthese = changeRightParenthese;
                    } else if (popPriorityValue == changeRightPriorityValue) {//우선순위가 같을 때
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


                    }


                    if (stack.isEmpty() != true && stack.isSingle() != true) {
                        //stack이 비어있지 않을 경우
                        // whereRightParenthese = stackEmptyCheckNum + (inputTexts[i].length() - 1);
                        resultTexts[resultPair] = resultParenthese;
                        resultPair = whereRightParenthese - resultPair;//(inputTexts[i].length() - 1) - resultPair;
                        resultTexts[resultPair] = rightParenthese;
                        //System.out.println(resultParenthese + "" + rightParenthese);
                    } else if (stack.isEmpty() == true && stack.isSingle() == true) {//stack이 비어있을 경우

                        resultTexts[stackEmptyCheckNum++] = resultParenthese;
                        resultTexts[stackEmptyCheckNum++] = rightParenthese;

                    } else if (stack.isEmpty() == true && stack.isSingle() != true) {// 다중 괄호 이면서 마지막 괄호 처리
                        resultTexts[resultPair] = resultParenthese;
                        resultPair = whereRightParenthese - resultPair;//(inputTexts[i].length() - 1) - resultPair;
                        resultTexts[resultPair] = rightParenthese;
                        stackEmptyCheckNum += whereRightParenthese + 1;
                    }


//
                }

            }
            String result = "";
            //   stack.display();
            // System.out.println("하이");
            for (int b = 0; b < resultTexts.length; b++) {
                // System.out.print(resultTexts[b]);
                result = result + resultTexts[b];
            }
            //  System.out.println();

            finalResultList.add(result);
            stackEmptyCheckNum = 0;
        }
        // System.out.println("bye");
        for (int i = 0; i < finalResultList.size(); i++) {
            System.out.println(finalResultList.get(i));
        }


    }
}
