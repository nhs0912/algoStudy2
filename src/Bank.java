import java.util.Random;

/**
 * Created by nhs0912 on 2016-11-25.
 * 작성자 : 노희석
 * 알고리즘 순서
 * 1) 카드, 선수,카드 게임 클래스를 만든다.
 * 2) 52장의 카드정보를 입력하고 카드 배열에 저장한다.
 * 3) 카드 배열 안에 카드를 섞는다.
 * 4) 4명의 선수에게 7장씩 카드를 나누어준다.
 * 5) 각 선수들의 카드 숫자를 더하고 sun변수에 저장한다.
 * 6) 각 선수들의 배열을 복사해서 임시배열을 생성한다.
 * 7) 임시배열에서 각 선수들의 합계(sum변수)를 기준으로 점수가 제일 낮은 선수 순으로 정렬한다.
 * 7) 임시배열에서  첫번째와 두번째 선수의 합계를 비교한다.
 * 8) 같으면 3)으로 돌아가서 다시 플레이한다.
 * 9) 다르면 playerDisplay() 메서드 실행해서 각 선수와 카드 정보,합계 그리고 마지막 우승자를 출력한다.
 */


class Card { //카드
    char kind; //스페이스(S),다이아몬드(D),하트(H),클로버(C)
    int num; //카드 번호

    Card(char kind, int num) {//카드 생성자
        this.kind = kind;
        this.num = num;
    }

    public int getNum() {//카드 번호 얻기
        return num;
    }

    @Override
    public String toString() {//카드 종류와 번호 출력
        return kind + Integer.toString(num);
    }
}

class Player {//선수

    Card[] cards;//갖고 있는 카드
    int num = 0; //player 번호
    int sum = 0; //카드 총합

    Player(int num, Card[] cards) {//선수 생성자
        this.num = num;
        this.cards = cards;

        for (int i = 0; i < cards.length; i++) {//선수 카드 총합 계산
            this.sum += cards[i].getNum();
        }
    }

    public int getNum() { //선수 번호 얻기
        return num;
    }

    public int getSum() { //선수 카드 총합 얻기
        return sum;
    }

    public void getDisplayCard() {//가지고 있는 카드 정보 보여주기
        for (int j = 0; j < cards.length; j++) {
            if (j == cards.length - 1)//맨 마지막 카드 출력
            {
                System.out.print(cards[j].toString() + ": ");
            } else {
                System.out.print(cards[j].toString() + ",");
            }
        }
    }

}

class CardGame {//카드 게임 실행

    char[] kinds = new char[]{'S', 'D', 'H', 'C'}; //스페이스(S),다이아몬드(D),하트(H),클로버(C)
    Card[] cardList = new Card[52]; //카드 52장의 정보
    Player[] players = new Player[4]; //Player 객체를 저장하는 배열(선수들을 모아놓는 배열)

    CardGame() {

        int cardIndex = 0; //cardList[] 배열 주소값
        for (int i = 0; i < kinds.length; i++) {//카드 종류
            for (int j = 0; j < cardList.length / 4; j++) {//1~13까지 번호를 붙여 인스턴스 생성
                Card card = new Card(kinds[i], (j + 1)); //카드 객체 생성
                cardList[cardIndex++] = card; //카드 객체 각 배열에 저장
            }
        }
    }

    /*
        Randomize in Place 방식으로 자리를 바꾼다.
        n = length[A]
        for i = 1 to n
        swap A[i] ↔ A[Random(i, n)]
    */
    void cardShuffle() {
        //카드를 섞는 메서드
        Random random = new Random(); //random숫자를 위한 random 인스턴스 생성
        for (byte i = 0; i < cardList.length; i++) {
            int randomNum = random.nextInt(cardList.length); //cardList 길이를 입력해서 0~(cards-1) 만큼의 숫자를 출력한다.
            //두개의 카드 자리를 바꾼다.
            Card tmp = cardList[i];
            cardList[i] = cardList[randomNum];
            cardList[randomNum] = tmp;
        }

    }

    void distributeCard() {//카드를 나누어주는 메서드
        int card_index = 0; //선수 카드 배열 인덱스 값
        Card[] cards;
        for (int i = 0; i < 4; i++) {//Player1~4까지
            cards = new Card[7]; //7개 카드를 저장하는 배열 생성
            for (int j = 0; j < 7; j++) { //카드 7장씩 나누어준다.
                cards[j] = cardList[card_index++]; //섞은 카드를 7개씩 선수카드배열에 저장
            }
            Player player = new Player(i + 1, cards); //플레이어 인스턴스 생성
            players[i] = player; //Players 배열에 player 객체 저장
        }
    }

    Player whoIsWinner(Player[] players) {
        //누가 우승자인지 찾아내는 메서드
        Player[] tmpPlayers = players.clone(); //players 배열을 복사.
        Player WinnerPlayer = null; //우승 선수
        for (int i = 0; i < tmpPlayers.length - 1; i++) {//player 최소점수 순으로 정렬한다.
            for (int j = i + 1; j < tmpPlayers.length; j++) {
                if (players[j].getSum() < tmpPlayers[i].getSum()) {
                    Player tmpPlayer = tmpPlayers[i];
                    tmpPlayers[i] = tmpPlayers[j];
                    tmpPlayers[j] = tmpPlayer;
                }
            }
        }
        WinnerPlayer = tmpPlayers[0]; //제일 처음 선수가 최소값을 가진 우승자
        if (WinnerPlayer.getSum() == tmpPlayers[1].getSum()) {
            //우승자와 players[1](우승자 다음 최소값을 가진 선수의 값을 비교해서 2명이상이면
            play(); //다시 플레이
        }
        return WinnerPlayer; //우승한 선수를 반환
    }

    void play() {
        cardShuffle(); //카드를 섞는다.
        distributeCard(); //카드를 나누어준다.

    }

    void display() {
        //카드 리스트안에 카드 출력
        for (int i = 0; i < cardList.length; i++) {
            System.out.print(cardList[i].toString() + " ");
        }
    }

    void playerDisplay() {
        //플레이어 카드 정보와 합계 우승자까지 출력하는 메서드
        Player winner = whoIsWinner(players);
        for (int i = 0; i < 4; i++) {//4명의 선수 정보 출력
            System.out.print("Player" + players[i].getNum() + ": "); //선수 번호 출력
            players[i].getDisplayCard(); //선수 카드 정보 출력
            System.out.println("sum = " + players[i].getSum()); //선수 합계 출력
        }
        System.out.println("Winner : Player" + winner.getNum()); //우승자 출력
    }
}

public class Bank {
    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.play(); //카드 게임 플레이
        cardGame.playerDisplay(); //카드 정보 표시
    }
}
