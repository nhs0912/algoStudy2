import java.io.*;
import java.util.StringTokenizer;

/**
 * 2017-01-22
 * 문제 번호 : 10814
 * 문제 이름 : 나이순 정렬
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/10814
 */
class Main {
    static Human[] sortedPeople;

    class Human {
        private int age = 0;
        private String name;

        Human(int age, String name) {
            this.age = age;
            this.name = name;

        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    void Merge(int left, int middle, int right, Human[] arr) {
        int leftPointer = left;
        int rightPointer = middle + 1;
        int index = left;//sortedPeople array index
        while (leftPointer <= middle || rightPointer <= right) {
            if (leftPointer <= middle && rightPointer <= right) {
                if (arr[leftPointer].getAge() <= arr[rightPointer].getAge()) {
                    sortedPeople[index] = arr[leftPointer++];
                } else {
                    sortedPeople[index] = arr[rightPointer++];
                }
            } else if (leftPointer <= middle && rightPointer > right) {
                sortedPeople[index] = arr[leftPointer++];
            } else {
                sortedPeople[index] = arr[rightPointer++];
            }
            index++;
        }

        for (int i = left; i < right + 1; i++) {
            arr[i] = sortedPeople[i];
        }
    }

    void MergeSort(int left, int right, Human[] arr) {
        int middle;
        if (left < right) {
            middle = (left + right) / 2;
            MergeSort(left, middle, arr);
            MergeSort(middle + 1, right, arr);
            Merge(left, middle, right, arr);
        }
    }

    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());//테스트 갯수
        Human[] people = new Human[N]; //명단 작성
        sortedPeople = new Human[N];
        int index = 0;
        while (N-- > 0) {
            //테스트 갯수 만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine().trim());//나이와 이름 입력
            Human human = new Human(Integer.parseInt(st.nextToken()), st.nextToken());//human 생성
            people[index++] = human; //명단에 넣기
        }

        MergeSort(0, people.length - 1, people);

        for (Human h : people) {
            bw.write(h.getAge() + " " + h.getName() + "\n");
        }
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }
}