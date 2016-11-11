import java.util.Scanner;

/**
 * Created by nhs0912 on 2016-11-08.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a == b) {
            if (b < c) {
                System.out.println(b);
            } else if (b > c) {
                System.out.println(c);
            } else if (b == c) {
                System.out.println(c);
            }
        } else if (a == c) {
            if (c < b) {
                System.out.println(c);
            } else if (b < c) {
                System.out.println(b);
            } else if (b == a) {
                System.out.println(b);
            }
        } else if (b == c) {
            if (a < b) {
                System.out.println(a);
            } else if (b < a) {
                System.out.println(b);
            } else if (a == b) {
                System.out.println(a);
            }
        } else if (a > b) {
            if(b>c)
            {
                System.out.println(b);

            }else if(b<c){
                System.out.println(c);
            }
        }


//        if (a == b && b < c) {
//            System.out.println(b);
//        } else if (a == c && c < b) {
//            System.out.println(c);
//        } else if (b == c && c < a) {
//            System.out.println(c);
//        } else if (b == c && c > a) {
//            System.out.println(a);
//        } else if (a == b && b == c && c == a) {
//            System.out.println(a);
//        } else if (a == b && a < c) {
//            System.out.println(a);
//        } else if (a == b && a > c) {
//            System.out.println(c);
//        } else if (a == c && a < b) {
//            System.out.println(a);
//        } else if (a == c && a > b) {
//            System.out.println(b);
//        } else if (a < b && b < c) {
//            System.out.println(b);
//        } else if (a < b && b > c) {
//            if (a > c) {
//                System.out.println(a);
//            } else if (c > a) {
//                System.out.println(c);
//            }
//
//        } else if (a > b && b < c) {
//            if (a > c) {
//                System.out.println(c);
//            } else if (a < c) {
//                System.out.println(a);
//            }
//
//        } else if (a > b && b > c) {
//            System.out.println(b);
//        }

    }
}
