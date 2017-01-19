package A;

import java.util.Random;

/**
 * Created by heeseoknoh on 01/12/2016.
 */


class Lotto {
    int[] num;
    int[] result = new int[6];

    Lotto() {
        System.out.println("생성");
    }

    Lotto(int[] num) {
        this.num = num;
        shuffle();
        //display();
        export();
    }

    void shuffle() {
        Random random = new Random();
        for (int i = 0; i < num.length; i++) {
            int ranNum = random.nextInt(num.length);
            int tmp = num[i];
            num[i] = num[ranNum];
            num[ranNum] = tmp;
        }
    }

    void export() {

        for (int i = 0; i < 6; i++) {
            result[i]=num[i];
//            if (i == 5) {
//                System.out.println(num[i]);
//            } else {
//                System.out.print(num[i] + ",");
//            }
        }


    }


    void mergeSort(){

    }

    void display() {
        for (int a : num) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}


public class Test2 {

    public static void main(String[] args) {
        int[] num = new int[45];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }
        Lotto lotto = new Lotto(num);


        //Random random = new Random();
        //int ranNum = random.nextInt(45);
        //System.out.println(ranNum);
    }
}
