package Study;

class Fibonacci {
    /**
     *
     * 피보나치 수열_ 반복문으로 구현
     */

    public static void main(String[] args) {

        int[] numbers = new int[20];

        numbers[0] = 0;
        numbers[1] = 1;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");

        }
    }
}