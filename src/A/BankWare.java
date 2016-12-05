package A;

/**
 * Created by heeseoknoh on 07/11/2016.
 */
public class BankWare {
    public Boolean isOverlap(String txt) {


        return false;
    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        String txt = sc.nextLine();
        String txt = "i see love love love you you and me i have money I I Love";
        String[] splitTxt = txt.split(" ");
        String[] overlapTxt = new String[splitTxt.length];
        int cnt = 0;
        Boolean wasPrint = false;
        int[] splitTxtCnt = new int[splitTxt.length];
//        for (String a : splitTxt) {
//            System.out.println(a);
//        }

        for (int i = 0; i < splitTxt.length - 1; i++) {
            cnt = 1;
            for (int j = i + 1; j < splitTxt.length; j++) {
                if (splitTxt[i].equals(splitTxt[j])) {
                    splitTxtCnt[i] = ++cnt;
                    //overlapTxt[i] = splitTxt[i];
                }
            }
        }
//        for(String a : overlapTxt)
//        {
//            System.out.println(a);
//        }
        int index = 0;
        for (int i = 0; i < splitTxt.length; i++) {
            if (overlapTxt[0] != null) {
                wasPrint = false;
                for (int j = 0; j < overlapTxt.length; j++) {
                    //중복 검사
                    if (splitTxt[i].equals(overlapTxt[j])) {
                        wasPrint = true;
                        break;
                    }
                }
                if (wasPrint != true) {
                    System.out.println(splitTxt[i] + "(cnt=" + splitTxtCnt[i] + ")");
                    overlapTxt[index++] = splitTxt[i];
                }
            } else {
                System.out.println(splitTxt[i] + "(cnt=" + splitTxtCnt[i] + ")");
                overlapTxt[index++] = splitTxt[i];
            }
        }
    }
}
