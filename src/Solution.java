import java.io.*;
import java.util.*;


public class Solution {


    void reverseWord(String str) {
        if (str.length() == 0) {
            return;
        } else {
            reverseWord(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    void printInBinary(int n) {
        if (n < 2) {
            System.out.println(n);
        }
        else{
            printInBinary(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
//        new Solution().reverseWord(st.nextToken());
        new Solution().printInBinary(Integer.parseInt(br.readLine()));

    }
}