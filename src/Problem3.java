/**
 * R0422.java를 이메일에 첨부하여 보냄
 * 이메일 제목: [자바교육][3일차]노희석
 * 이메일 내용: 건의사항
 * <p>
 * -------3일차 과제
 * n이 짝수이면 n/2를 , 홀수 이면 3n+1을 구하는 계산을 한다. 결과가 1이 될 떄까지 반복하는 간단한 문제다.
 * 주어진 구간에서 가장 1이 되기까지 가장 긴 시퀀스를 만드는 값을 찾는다.
 * 예를 들어, 1-5사이의 값은
 * <p>
 * 1: 1
 * 2: 2->1
 * 3: 3->10->5->16->8->4->2->1
 * 4:4->2->1
 * 5:5->16->8->4->2->1
 * <p>
 * 따라서 가장 긴 sequence를 만드는 값은 3이고 시퀀스의 길이는 8입니다.
 **/
class Problem3 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        length(200000);

        long endTime = System.currentTimeMillis();

        System.out.println((endTime - startTime) + "ms elapsed");
    }

    public static int length(int max) {
        int cnt = 1;//시퀀스 길이
        int[] savedlength = new int[max + 1];
        long number = max;// number 가 int 범위를 넘어가는 경우도 있기 때문에 long으로 선언
        int bigCnt = 0; //시퀀스 갯수
        int bigNum = 0; //시퀀스가 제일 긴 숫자
        for (int i = 1; i <= max; i++) {

            long num = i;// 홀짝에 의해서 변하는 변수
            cnt = 1;//숫자가 바뀔 때마다 시퀀스 길이 1로 초기화
            //System.out.print(num + " ");

            while (num != 1) {

                if (num <= max && savedlength[(int) num] != 0) {
                    //max 범위 안에서 시퀀스 길이를 저장한다.
                    cnt += savedlength[(int) num] - 1;
                    break;
                }
                if (num % 2 == 1) {
                    //홀수인 경우
                    num = (num * 3) + 1;

                } else if (num % 2 == 0) {
                    //짝수인 경우
                    num = num / 2;
                }
                //System.out.print("-> " + num);
                cnt++;
            }
            if (bigCnt < cnt) {
                //시퀀스 길이가 bigCnt 보다 큰 것이 있다면
                bigCnt = cnt;
                bigNum = i;
            }

            savedlength[i] = cnt;
            //System.out.print(cnt+" ");
        }


        System.out.println("제일 시퀀스가 큰 숫자 : " + bigNum + ", 시퀀스 길이 : " + bigCnt);
        return cnt;

    }

}
