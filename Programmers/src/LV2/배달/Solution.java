import java.util.*;
class Solution {
    final int MAX = 500001;
    int[][] graph;
    boolean[] checked;
    int[] dist;
    int N;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
    
    public int solution(int N, int[][] road, int K) {
        this.N = N;
        int ans = 0;
        setUp(road);
        
        dijkstra(0);
        
        for(int cost : dist){
            if(cost<=K){
                ans++;
            }
        }

        return ans;
    }
    void dijkstra(int node){
        Arrays.fill(dist,MAX);
        dist[node]=0;
        pq.add(new int[]{0,node});
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int start = info[1];
            if(checked[start]){
                continue;
            }
            checked[start]=true;
            for(int v = 0;v<N;v++){
                if(dist[v]>dist[start]+graph[start][v]){
                    dist[v]=dist[start]+graph[start][v];
                    pq.add(new int[]{dist[v],v});
                }
            }
            
        }
    }
    
    void setUp(int[][] road){
        graph = new int[N][N];
        checked = new boolean[N];
        dist = new int[N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j){
                    graph[i][j]=0;
                }else{
                    graph[i][j]=MAX;
                }
            }
        }
        
        for(int [] info : road){
            if(graph[info[0]-1][info[1]-1]!=MAX){
                graph[info[0]-1][info[1]-1] = Math.min(info[2],graph[info[0]-1][info[1]-1]);
                graph[info[1]-1][info[0]-1] = Math.min(info[2],graph[info[1]-1][info[0]-1]);
            }else{
                graph[info[0]-1][info[1]-1] = info[2];
                graph[info[1]-1][info[0]-1] = info[2];
            }
        }
    }
}
