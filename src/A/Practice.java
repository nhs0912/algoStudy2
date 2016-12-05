package A;

/**
 * Created by nhs0912 on 2016-12-03.
 * 1. Snake 문자 <----> camel 문자 서로 변환하는 메서드 구현
 * 2. 10진수를 이진수로 바꾸어서 1의 개수 출력 하는 메서드
 * 3. 시저 문자 (보안문자)
 * 4. 스트링의 숫자 문자를 숫자로 변환  "523" ---> 숫자로 바꾸어야함
 **/


class Problem {

    String Solution1(String str) {
        //1. Snake 문자 <----> camel 문자 서로 변환하는 메서드 구현
        //ex) this_is_love -> thisIsLove

        Boolean checkCamel = true; //camel 문자인지 확인

        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            //Camel 문자인지 판별
            if ((int) ch[i] == 95) {
                checkCamel = false;
                break;
            }

        }

        if (checkCamel) {//Camel to Snake
            int bigCharCnt = 0;//대문자 갯수
            for (int i = 0; i < ch.length; i++) {
                if ((int) ch[i] > 64 && (int) ch[i] < 91) {//대문자이면
                    bigCharCnt++;
                }
            }
            char[] result = new char[ch.length + bigCharCnt];
            int index = 0;
            for (int i = 0; i < ch.length; i++) {

                if ((int) ch[i] > 64 && (int) ch[i] < 91) {//대문자이면
                    result[index++] = '_';
                    result[index++] = (char) ((int) ch[i] + 32);

                } else {
                    result[index++] = ch[i];
                }
            }

            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        } else { //Snake to Camel
            int cnt=0;//_ 갯수
            for(int i=0; i<ch.length;i++)
            {
                if(ch[i]=='_')
                {
                    cnt++;
                }
            }

            char[] result = new char[ch.length-cnt];

            int index=0;
            for(int i=0; i<ch.length;i++)
            {
                if(ch[i]=='_')
                {
                    ch[i+1]=(char)((int)ch[i+1]-32);
                    continue;
                }
                else{
                    result[index++]=ch[i];
                }
            }

            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();

        }

        return null;
    }


    int Solution2(int num) {
        //2. 10진수를 이진수로 바꾸어서 1의 개수 출력 하는 메서드
        String str = Integer.toBinaryString(num);
        // System.out.println(str);
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }

    char[] Solution3(String str) {
        //3. 시저 문자 (보안문자)
        char[] ch = str.toCharArray();
        char[] result = new char[ch.length];
        for (int i = 0; i < ch.length; i++) {
            int asciiNum = (int) ch[i];
            char changeText;
            if (asciiNum == 32)//빈칸
            {
                continue;
            } else if (asciiNum > 119)//x(119) 부터
            {
                changeText = (char) ((asciiNum + 3) - 26);
            } else {
                changeText = (char) (asciiNum + 3);
            }
            result[i] = changeText;
        }

        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();

        return result;
    }

    int Solution4(String str) {
        //4. 스트링의 숫자 문자를 숫자로 변환  "523" ---> 숫자로 바꾸어야함
        char[] ch = str.toCharArray(); //String 문자를 char 배열에 넣기
        int[] num = new int[ch.length]; //자릿수 곱하기
        int resultNum = 0;
        String number = "0123456789";
        for (int j = 0; j < num.length; j++) {
            int tenNum = 1;
            for (int i = num.length - (j + 1); i > 0; i--) {
                tenNum *= 10;
            }
            num[j] = tenNum;//자릿수 배열 입력
        }
        for (int i = 0; i < ch.length; i++) {
            resultNum += number.indexOf(ch[i]) * num[i];
        }
        return resultNum;
    }

}

public class Practice {
    public static void main(String[] args) {
        Problem problem = new Problem();
        //System.out.println(problem.Solution2(10));
        //System.out.println(problem.Solution4("523"));
        // problem.Solution3("the simple is the best");
        //this_is_love -> thisIsLove
        problem.Solution1("thisIsLove");
        problem.Solution1("this_is_love");


    }
}
