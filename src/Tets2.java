/**
 * Created by nhs0912 on 2016-11-26.
 */
public class Tets2 {

    public static void main(String[] args) {


        int[] num = new int[]{4, 3, 5, 1, 41, 2};

        for (int a : num) {
            System.out.print(a + " ");
        }
        System.out.println();

        int min, tmp;
        for (int i = 0; i < num.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[min] > num[j]) {
                    min = j;
                }
            }
            tmp = num[min];
            num[min] = num[i];
            num[i] = tmp;
        }


        for (int a : num) {
            System.out.print(a + " ");
        }

    }
}
