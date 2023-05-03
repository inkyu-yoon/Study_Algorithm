package LV2.전력망을둘로나누기;
import java.util.*;
class Solution {
    Deque<int[]> q;
    boolean[] checked;
    int[][] wires;
    int num;
    int ans;
    public int solution(int n, int[][] wires) {
        this.wires = wires;
        this.num = n;
        ans = Integer.MAX_VALUE;

        for(int [] wire : wires){
            bfs(wire);
        }

        return ans;
    }
    public void bfs(int[] wire){
        q = new ArrayDeque<>();
        checked = new boolean[num+1];
        int node = wire[0];
        q.offer(new int[]{node,1});
        checked[node]=true;
        int count = 1;
        while(!q.isEmpty()){
            int [] info = q.poll();
            int n = info[0];
            int depth = info[1];
            for(int[] w : wires){
                if(check(wire,w)){
                    continue;
                }
                if(w[0]==n && !checked[w[1]]){
                    q.offer(new int[]{w[1],++depth});
                    checked[w[1]]=true;
                    count++;
                }else if(w[1]==n && !checked[w[0]]){
                    q.offer(new int[]{w[0],++depth});
                    checked[w[0]]=true;
                    count++;
                }
            }
        }
        ans = Math.min(ans,Math.abs(num-count*2));
    }

    boolean check(int[] wire,int[] w){
        if(wire[0]==w[0] && wire[1]==w[1]){
            return true;
        }
        return false;
    }
}
