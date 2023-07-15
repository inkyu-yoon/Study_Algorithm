package LV2.배달;
import java.util.*;
class Solution4 {
    List<List<Node>> list = new ArrayList<>();
    public int solution(int N, int[][] road, int K) {

        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        for(int[] info : road){
            int u = info[0], v = info[1];
            int cost = info[2];
            list.get(u).add(new Node(v,cost));
            list.get(v).add(new Node(u,cost));
        }


        return dijk(N,1,K);
    }

    public int dijk(int N, int start, int K){
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,dist[start]));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int u = now.idx,cost=now.cost;

            if(dist[u] > cost){
                continue;
            }

            int len = list.get(u).size();
            for(int i=0;i<len;i++){
                Node next = list.get(u).get(i);
                int v = next.idx;
                if(dist[v]> cost+ next.cost){
                    dist[v] = cost+next.cost;
                    pq.offer(new Node(v,dist[v]));
                }
            }
        }

        return (int)Arrays.stream(dist).filter(i->i<=K).count();

    }



    static class Node implements Comparable<Node>{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node next){
            return this.cost - next.cost;
        }
    }
}