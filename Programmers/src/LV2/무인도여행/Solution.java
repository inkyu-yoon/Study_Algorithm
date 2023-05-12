package LV2.무인도여행;

import java.util.*;
class Solution {
    int R, C;
    String[][] map;
    int [] dr = {1,-1,0,0};
    int [] dc = {0,0,1,-1};
    boolean[][] checked;
    Queue<int[]> q = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();
    public int[] solution(String[] maps) {
        int[] answer = {};
        setUp(maps);

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!map[i][j].equals("X") && !checked[i][j]){
                    q.offer(new int[]{i,j});
                    bfs();
                }
            }
        }

        if(ans.size()==0){
            return new int[]{-1};
        }

        Collections.sort(ans);

        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    void bfs(){
        int sum = 0;
        while(!q.isEmpty()){
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];
            if(checked[r][c]){
                continue;
            }

            sum+=Integer.parseInt(map[r][c]);
            checked[r][c]=true;
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(0<=nr && nr<R && 0<=nc && nc<C && !map[nr][nc].equals("X") && !checked[nr][nc]){
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        ans.add(sum);

    }

    void setUp(String[] maps){
        R = maps.length;
        C = maps[0].length();
        checked = new boolean[R][C];
        map = new String[R][];
        for(int i=0;i<R;i++){
            map[i]=maps[i].split("");
        }
    }
}