/**
 * Created by nhs09 on 2016-10-22.
 */
public class CoinProblem {


    public static int solution(int[] coinTypes, int money) {
        // money = 5;
        //coinTypes = new int[]{1, 2};
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < coinTypes.length; i++) {
            int j = 1;
            result = 0;
            if (coinTypes[i] == 1) {
                cnt++;
            } else {
                while (result >= 0) {
                    result = money - coinTypes[i] * j++;

                    for (int k = i; k < coinTypes.length && result >= 0; k++) {
                        if (coinTypes[k] == coinTypes[i]) {
                            continue;
                        } else if (result % coinTypes[k] == 0) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] coin = new int[]{1, 5, 10};
        int money = 100;
        System.out.println(solution(coin, money));
    }
}


