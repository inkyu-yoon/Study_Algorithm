package LV3.합승택시요금;

import java.util.*;
class Solution {
    final int MAX = 20000001;
    int n;
    int[][] g;
    int[] dist;
    boolean[] checked;
    PriorityQueue<int[]> pq;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = MAX;
        setUp(n,fares);

        int[] result1 = dijk(s);

        for(int i=1;i<=n;i++){
            int[] result2 = dijk(i);
            answer = Math.min(answer,result1[i-1]+result2[a-1]+result2[b-1]);
        }
        return answer;
    }
    int[] dijk(int start){
        pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist = new int[n];
        checked = new boolean[n];
        Arrays.fill(dist,MAX);
        dist[start-1] = 0;
        pq.offer(new int[]{dist[start-1],start-1});
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int u = info[1];
            if(checked[u]){
                continue;
            }
            checked[u]=true;
            for(int v=0;v<n;v++){
                if(dist[v]>dist[u]+g[u][v]){
                    dist[v]=dist[u]+g[u][v];
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }
        return dist;

    }
    void setUp(int n,int[][] fares){
        this.n=n;
        g = new int[n][n];
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(r==c){
                    g[r][c]=0;
                }else{
                    g[r][c]=MAX;
                }
            }
        }


        for(int r=0;r<fares.length;r++){
            int[] fare = fares[r];
            for(int c=0;c<n;c++){
                g[fare[0]-1][fare[1]-1]=fare[2];
                g[fare[1]-1][fare[0]-1]=fare[2];
            }
        }

    }
}