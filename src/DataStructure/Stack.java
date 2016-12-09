package DataStructure;

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