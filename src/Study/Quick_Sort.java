package Study;

import java.io.*;

/**
 * Created by nhs09 on 2017-01-28.
 */
public class Quick_Sort {


    public int partition(int[] arr, int begin, int end) {
        int pivot, temp, left, right;
        left = begin;
        right = end;
        pivot = (begin + end) / 2;
        while (left < right) {
            while ((arr[left] < arr[pivot]) && (left < right)) {
                left++;
            }
            while (arr[right] >= arr[pivot] && (left < right)) {
                right--;
            }
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                if (left == pivot) {
                    pivot = right;
                }
            }
        }

        //left==right
        temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
        return right;


    }

    void QuickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int p;
            p = partition(arr, begin, end);
            QuickSort(arr, begin, p - 1);
            QuickSort(arr, p + 1, end);
        }
    }


    public static void main(String[] args) throws IOException {

        //int[] arr = new int[]{5, 4, 3, 2, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];

        int index = 0;
        while (N-- > 0) {
            arr[index++] = Integer.parseInt(br.readLine().trim());
        }
        new Quick_Sort().QuickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.close();


    }
}
