package LV3.섬연결하기;

import java.util.*;
class Solution2 {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        Arrays.sort(costs,(a,b)->a[2]-b[2]);

        for(int[] cost : costs){
            if(find(cost[0])!=find(cost[1])){
                union(cost[0],cost[1]);
                answer+=cost[2];
            }
        }
        return answer;
    }
    void union(int num1,int num2){
        int a = find(num1);
        int b = find(num2);
        if(a!=b){
            parent[b]=a;
        }
    }

    int find(int num){
        if(parent[num]==num){
            return num;
        }else{
            return find(parent[num]);
        }
    }
}
