package 바킹독.위상정렬.계보복원가호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 계보 상 자식 관계 모두 저장
    static Map<String, List<String>> relation = new HashMap<>();

    // 직계 자손만 저장
    static Map<String, PriorityQueue<String>> directChildren = new HashMap<>();

    // 각 사람 별 간선이 오는 개수 저장
    static Map<String, Integer> indegree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            String name = input[i];
            relation.put(name, new ArrayList<>());
            directChildren.put(name, new PriorityQueue<>());
            indegree.put(name, 0);

        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            String young = input[0];
            String old = input[1];
            // 계보 상 자식(직계인지 아닌지는 모름) 추가
            relation.get(old).add(young);

            // 자식들은 inDegree 값 증가
            indegree.put(young, indegree.get(young) + 1);
        }
        StringBuilder ans = new StringBuilder();

        Queue<String> q = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        int K = 0;
        for (String name : indegree.keySet()) {
            // 들어오는 간선이 없다는 것은 최고 조상이라는 의미
            if (indegree.get(name) == 0) {
                K++;
                pq.offer(name);
                q.offer(name);
            }
        }
        ans.append(K + "\n");

        while (!pq.isEmpty()) {
            ans.append(pq.poll() + " ");
        }
        ans.append("\n");

        // 위상 정렬
        while (!q.isEmpty()) {
            String parent = q.poll();
            List<String> children = relation.get(parent);
            for (String child : children) {
                int n = indegree.get(child);
                // 간선이 1개 남아있는 경우 직계 자손
                // 들어오는 간선이 0이 되는 경우 큐에 추가
                if (n == 1) {
                    directChildren.get(parent).add(child);
                    q.offer(child);
                }
                indegree.put(child, n - 1);
            }
        }

        // 직계 자손 구하기
        for (String parent : directChildren.keySet()) {
            StringBuilder sb = new StringBuilder();
            PriorityQueue<String> children = directChildren.get(parent);
            sb.append(parent + " " + children.size() + " ");
            while (!children.isEmpty()) {
                sb.append(children.poll() + " ");
            }
            pq.offer(sb.toString());
        }

        while (!pq.isEmpty()) {
            ans.append(pq.poll() + "\n");
        }

        System.out.println(ans);
    }
}
