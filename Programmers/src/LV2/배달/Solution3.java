package LV2.배달;

import java.util.*;
class Solution3 {
    final int MAX_VALUE = 500001;
    int[][] graph;
    PriorityQueue<int[]> pq;
    public int solution(int N, int[][] road, int K) {

        setUp(N,road);

        return dijk(N,K);
    }

    int dijk(int N,int K){
        int[] dist = new int[N];
        boolean[] checked = new boolean[N];

        Arrays.fill(dist,MAX_VALUE);
        dist[0]=0;

        pq.offer(new int[]{dist[0],0});

        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int u = info[1];

            if(checked[u]){
                continue;
            }

            checked[u]=true;

            for(int v = 0;v<N;v++){
                if(dist[v]>dist[u]+graph[u][v]){
                    dist[v]=dist[u]+graph[u][v];
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }
        return (int)Arrays.stream(dist).filter(n->n<=K).count();
    }

    void setUp(int N, int[][] road){
        pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        graph = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j){
                    graph[i][j]=0;
                }else{
                    graph[i][j]=MAX_VALUE;
                }
            }
        }

        for(int[] r : road){
            int u = r[0]-1;
            int v = r[1]-1;
            graph[u][v]=Math.min(graph[u][v],r[2]);
            graph[v][u]=Math.min(graph[v][u],r[2]);
        }


    }
}
