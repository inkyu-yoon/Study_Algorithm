package LV2.배달;

import java.util.*;
class Solution2 {
    final int MAX_VALUE = 500001;
    int[][] g;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        setUp(N, road);


        return dijk(N,K);
    }
    int dijk(int N,int K){
        boolean[] checked = new boolean[N];
        int[] dist = new int[N];

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
            for(int v=0;v<N;v++){
                if(dist[v]>dist[u]+g[u][v]){
                    dist[v]=dist[u]+g[u][v];
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }

        return (int)Arrays.stream(dist).filter(n -> n<=K).count();

    }

    void setUp(int N, int[][] road){
        g = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j){
                    g[i][j] = 0;
                }else{
                    g[i][j] = MAX_VALUE;
                }
            }
        }

        for(int[] info : road){
            int u = info[0]-1;
            int v = info[1]-1;
            int cost = info[2];
            g[u][v] = Math.min(g[u][v],cost);
            g[v][u] = Math.min(g[v][u],cost);
        }


    }
}