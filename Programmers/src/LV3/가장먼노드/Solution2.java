package LV3.가장먼노드;

import java.util.*;
class Solution2 {
    boolean [] checked;
    Deque<int[]> q;
    List<int[]> list;
    int max = 0;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        setUp(n,edge);
        bfs(edge);
        HashSet<Integer> set = new HashSet<>();

        for(int[] result : list){
            if(result[2]==max){
                set.add(result[1]);
            }
        }
        return set.size();
    }


    void bfs(int[][] edge){
        while(!q.isEmpty()){
            int[] info = q.poll();
            list.add(info);
            int next = info[0];
            if(checked[next-1]==false){
                for(int[] vertex : edge){
                    if(vertex[0]==next){
                        q.offer(new int[]{vertex[1],vertex[0],info[2]+1});
                        max = Math.max(max,info[2]+1);
                    }else if(vertex[1]==next){
                        q.offer(new int[]{vertex[0],vertex[1],info[2]+1});
                        max = Math.max(max,info[2]+1);
                    }
                }
                checked[next-1]=true;
            }
        }
    }


    void setUp(int n,int[][] edge){
        checked = new boolean[n];
        q = new ArrayDeque<>();
        list = new ArrayList<>();
        for(int[] info : edge){
            if(info[0] == 1){
                q.offer(new int[]{info[1],info[0],1});
            }else if(info[1]==1){
                q.offer(new int[]{info[0],info[1],1});
            }
        }
        checked[0]=true;
    }
}