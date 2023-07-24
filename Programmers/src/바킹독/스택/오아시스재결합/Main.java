package 바킹독.스택.오아시스재결합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Person> s = new Stack<>();
        long ans =0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            int cnt = 1;

            while (!s.isEmpty() && s.peek().h <= h) {
                Person pop = s.pop();
                if (pop.h == h) {
                    cnt +=pop.cnt;
                }
                ans += pop.cnt;
            }

            if (!s.isEmpty()) {
                ans++;
            }

            s.push(new Person(h, cnt));


        }
        System.out.println(ans);
    }

    static class Person{
        int h;
        int cnt;

        public Person(int h, int cnt) {
            this.h = h;
            this.cnt = cnt;
        }
    }
}
