package 바킹독.스택.오아시스재결합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];

        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        Stack<Person> s = new Stack<>();

        s.push(new Person(0, 1));

        long ans = 0;
        for (int i = 1; i < N; i++) {
            int h = people[i];

            int cnt = 1;

            while (!s.isEmpty() && people[s.peek().idx] <= h) {
                Person pop = s.pop();
                if (people[pop.idx] == h) {
                    cnt += pop.num;
                }
                ans += pop.num;
            }

            if (!s.isEmpty()) {
                ans++;
            }

            s.push(new Person(i, cnt));

        }


        System.out.println(ans);
    }

    static class Person {
        int idx;
        int num;

        public Person(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
