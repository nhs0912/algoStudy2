package Study;

import java.io.*;

public class Merge_Sort {
    static int[] sorted;

    void MergeSort(int[] arr, int left, int right) {
        int middle;
        if (left < right) {
            middle = (left + right) / 2;
            MergeSort(arr, left, middle);
            MergeSort(arr, middle + 1, right);
            Merge(arr, left, middle, right);
        }
    }

    void Merge(int[] arr, int left, int middle, int right) {

        int leftPointer = left;
        int rightPointer = middle + 1;

        int index = left;
        while (leftPointer <= middle && rightPointer <= right) {

            if (arr[leftPointer] < arr[rightPointer]) {
                sorted[index] = arr[leftPointer++];
            } else {
                sorted[index] = arr[rightPointer++];
            }
            index++;
        }
        if (leftPointer > middle) {
            for (int i = rightPointer; i <= right; i++) {
                sorted[index++] = arr[i];
            }

        } else {
            for (int i = leftPointer; i <= middle; i++) {
                sorted[index++] = arr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }

    public static void main(String[] args) throws IOException {
        //File path = new File(".");
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
        sorted = new int[N];
        int index = 0;
        while (N-- > 0) {
            arr[index++] = Integer.parseInt(br.readLine().trim());
        }
        new Merge_Sort().MergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.close();

    }
}