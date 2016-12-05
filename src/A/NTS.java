//import java.util.Random;
//
///**
// * Created by T on 2016-11-18.
// * 알고리즘 순서
// * 1) 카드를 1차원 배열에 초기화 한다.
// * 2) 카드를 섞는다.
// * 3) 각 플레이어에게 7장씩 나누어준다.
// * 4) 각 플레이어의 점수를 더한다.
// * 5) 우승자 플레이어의 점수와 같은 플레이어가 2명이상 있다면 2)으로 돌아간다.
// * 6) 우승자가 1명이라면 각 플레이어의 카드 정보와 합계 그리고 우승자를 출력한다.
// * 각각 알고리즘 순서를 주석에 포함하였습니다.
// */
//class CardGame {
//    String[] cards; //카드 정보
//    byte players_cnt = 0;// 플레이어 수
//    String[][] player_card;//플레이어가 가지고 있는 카드 정보
//    byte[] player_score; //플레이어 총 점수 배열 (최대점수=88점)이기 때문에 byte형(1 byte) 선언
//
//    CardGame(byte players_cnt) {
//        this.players_cnt = players_cnt; //플레이어 숫자
//        this.player_score = new byte[players_cnt];//플레이어 점수 합계 저장
//        this.cards = new String[4 * 13]; //52장의 카드
//        this.player_card = new String[players_cnt][7]; //플레이어의 카드 정보 배열
//        char[] kind = new char[]{'S', 'D', 'H', 'C'}; //스페이스(S),다이아몬드(D),하트(H),클로버(C)
//
//        //1) 카드를 1차원 배열에 초기화 한다.
//        for (byte j = 0; j < cards.length; j++) { //1~52장까지 카드 초기화
//            int num = (j / 4) + 1; //1,2,3,4, ....13까지 4개의 카드를 연속으로 초기화한다.
//            int kindNum = j % 4; //4개의 카드 종류를 돌아가면서 한장씩 배분한다.
//            cards[j] = kind[kindNum] + String.valueOf(num); //카드 종류 + 숫자를 넣어서 cards[] 초기화
//        }
//
//
//    }
//
//    /*
//        Randomize in Place 방식으로 자리를 바꾼다.
//        n = length[A]
//        for i = 1 to n
//        swap A[i] ↔ A[Random(i, n)]
//    */
//    void cardShuffle() {
//        //카드를 섞는 함수
//        Random random = new Random(); //random숫자를 위한 random 인스턴스 생성
//        for (byte i= 0; i < cards.length; i++) {
//            int randomNum = random.nextInt(cards.length); //cards의 길이를 입력해서 0~(cards-1) 만큼의 숫자를 출력한다.
//            //두개의 숫자 자리를 바꾼다.
//            String tmp = cards[i];
//            cards[i] = cards[randomNum];
//            cards[randomNum] = tmp;
//        }
//
//    }
//
//    void play() { //카드 게임 플레이
//        byte card_index = 0; //cards[]의 배열 index
//        byte sum = 0; //카드 숫자 합계
//        //카드 배분
//        for (byte i = 0; i < players_cnt; i++) {//3) 각 플레이어에게 7장씩 나누어준다.
//            for (int j = 0; j < 7; j++) {//카드 7개씩 각 플레이어에게 나누어준다.
//                player_card[i][j] = cards[card_index++];
//            }
//        }
//        //점수 계산
//        for (byte i = 0; i < players_cnt; i++) {
//            sum = 0;
//            for (byte j = 0; j < player_card.length; j++) {
//                String[] split = player_card[i][j].split("\\D");
//                // "\D" 는 정규식 표현으로 숫자를제외한 모든 문자이다. 그래서 문자를 삭제하고 숫자만 남게한다.
//                //split할때 띄어쓰기부분은 숫자가 아닌 띄어쓰기만 들어있다.
//                //따라서 카드는 앞에 문자+숫자로 이루어져있기 때문에 split[1]에만 숫자 정보가 들어있다.
//                sum += Integer.parseInt(split[1]);
//                player_score[i] = sum; //점수 합계를 저장
//            }
//        }
//        byte winner_index = WhoisWinner(player_score); //winner_index 우승자 배열주소값 저장
//        Boolean check = CheckManyWinner(winner_index); //다수의 우승자가 있는지 판별
//        if (check) {//우승자가 2명 이상일 경우
//            cardShuffle(); //카드를 다시 섞는다.
//            play();//다시 플레이
//        } else {//우승자가 1명일 경우
//            playerCard_display();
//            System.out.print("Winner: ");
//            System.out.println("Player" + (winner_index+1)); //우승자 번호 = winner_index+ 1
//        }
//
//    }
//
//
//    Boolean CheckManyWinner(int winner_index) {//최소점수가 두명이상인지 검사
//        int checkCnt = 0; //중복 갯수
//        for (int i = 0; i < player_score.length; i++) {
//            if (player_score[winner_index] == player_score[i]) {
//                //2명 이상이면
//                checkCnt++;
//            }
//        }
//        if (checkCnt > 1) {//2개 이상 중복이 있다면 true
//            return true;
//        }
//        return false;
//    }
//
//    byte WhoisWinner(byte[] player_score) {
//        //우승자 누구인지 판별하는 메서드
//        byte min = player_score[0];//최소 점수
//        byte winner_index = 0;
//        for (byte i = 1; i < player_score.length; i++) {
//            if (min > player_score[i]) {//플레이어 점수가 더 작으면 tmp 값과 winner_index(우승자)값을 변경한다.
//                min = player_score[i];
//                winner_index = i;
//            }
//        }
//        return winner_index;// 플레이어 번호 = index+1
//    }
//
//    void playerCard_display() {//플레이어가 가지고 있는 카드정보 보여주기
//        for (int i = 0; i < player_card.length; i++) {
//            System.out.print("Player" + (i + 1) + ": ");//플레이어 숫자
//            for (int j = 0; j < player_card[i].length; j++) {//카드 출력
//                System.out.print(player_card[i][j] + " ");
//            }
//            System.out.print(": sum= " + player_score[i]); //플레이어 점수 출력
//            System.out.println();
//        }
//    }
//}
//
//public class NTS {
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//
//
//        byte player_cnt = 4; //플레이어 인원 수(1~6명의 게임 인원수 가정)
//        if (player_cnt > 1) {//플레이어가 2인 이상이면
//            CardGame cardGame = new CardGame(player_cnt);
//            cardGame.cardShuffle();//2) 카드를 섞는다.
//            cardGame.play();// 게임 시작
//        } else {//혼자 플레이한다면 메시지출력
//            System.out.println("플레이어는 2명이상이어야합니다.");
//        }
//
//        long end = System.currentTimeMillis();
//
//        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
//    }
//}
