package Study;

/**
 * Created by nhs09 on 2017-01-02.
 */

class Quick {


    void sort(int[] arr, int begin, int end) {
        if (begin < end) {
            int p = patition(arr, begin, end);
            sort(arr,begin,p-1);
            sort(arr,p+1,end);
        }
    }
    void swap(int[] arr, int left,int right)
    {
        int temp= arr[left];
        arr[left]= arr[right];
        arr[right]=arr[left];
    }

    int patition(int[] arr, int begin, int end) {
        int left=begin;
        int right=end;
        int pivot = (begin+end)/2;

        while(left<right)
        {
            while(arr[left]<arr[pivot] && left<right)
            {
                left++;
            }
            while(arr[right]>=arr[pivot] && left<right)
            {
                right--;
            }
            swap(arr,left,right);
            if(left==pivot)
            {
                pivot=right;
            }
        }



        return 0;
    }


}


public class Test {
    public static void main(String[] args) {
        System.out.println("Test 성공");
    }
}
