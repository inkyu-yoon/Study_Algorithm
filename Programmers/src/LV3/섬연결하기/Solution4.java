package LV3.섬연결하기;

import java.util.*;
class Solution4 {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i]=i;
        }

        Arrays.sort(costs,(a,b)->a[2]-b[2]);

        for(int[] info : costs){
            int u = info[0];
            int v = info[1];
            if(find(u)!=find(v)){
                union(u,v);
                answer+=info[2];
            }
        }



        return answer;
    }

    int find(int a){
        if(parent[a]==a){
            return a;
        }
        return find(parent[a]);
    }

    void union(int u, int v){
        int a = find(u);
        int b = find(v);

        if(a!=b){
            parent[b]=a;
        }
    }
}