package 큐.카드2;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // N장의 카드가 있다. 1부터 N까지의 번호가 붙어있다. 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 있다.
    // 제일 위에 있는 카드를 버린다. 그리고 제일 위에 있는 카드를 밑으로 옮긴다
    // 이거 무한 반복
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (true) {
            if (q.size() == 1) {
                System.out.println(q.poll());
                break;
            }
            q.poll();
            q.offer(q.poll());
        }


    }
}
