package 바킹독.이진검색트리.홍익투어리스트;

import java.util.*;
import java.io.*;

public class Main {
    // 1 i : i 번 구역이 명소가 아니었다면 명소가 되고 명소였다면 지정이 풀림
    // 2 x : 시계방향으로 x만큼 이동
    // 3 : 명소에 도달하기 위해 시계방향으로 최소 몇 칸 움직여야 하는지 출력, 존재하지 않는 경우 -1 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);
        TreeSet<Integer> treeSet = new TreeSet<>();

        input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            if (input[i - 1].equals("1")) {
                treeSet.add(i);
            }
        }
        int doHyun = 1;

        StringBuilder ans = new StringBuilder();

        while (Q-- > 0) {
            input = br.readLine().split(" ");
            if (input[0].equals("1")) {
                int numOfPlace = Integer.parseInt(input[1]);
                if (!treeSet.contains(numOfPlace)) {
                    treeSet.add(numOfPlace);
                } else {
                    treeSet.remove(numOfPlace);
                }
            } else if (input[0].equals("2")) {
                int move = Integer.parseInt(input[1]);
                doHyun = (doHyun + move) % (N);
                if (doHyun == 0) {
                    doHyun = N;
                }
            } else {
                int result = Integer.MAX_VALUE;

                if (!treeSet.isEmpty()) {
                    if (treeSet.ceiling(doHyun) != null) {
                        result = Math.min(result, treeSet.ceiling(doHyun) - doHyun);
                    } else {
                        result = Math.min(result, N - doHyun + treeSet.first());
                    }
                } else {
                    result = -1;
                }
                ans.append(result + "\n");
            }
        }

        System.out.println(ans);

    }
}
