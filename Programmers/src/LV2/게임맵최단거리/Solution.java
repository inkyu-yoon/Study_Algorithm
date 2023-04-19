package LV2.게임맵최단거리;

import java.util.*;
class Solution {
    Queue<int[]> q;
    boolean[][] checked;
    int[][] maps;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    int R;
    int C;

    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        this.maps = maps;

        q = new LinkedList<>();
        checked = new boolean[R][C];

        q.offer(new int[]{0,0,1});
        checked[0][0]=true;
        return bfs();
    }


    int bfs(){
        while(!q.isEmpty()){
            int [] point = q.poll();
            int r = point[0];
            int c = point[1];
            int d = point[2];

            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(0<=nr && nr<R && 0<=nc && nc<C && maps[nr][nc]==1 &&!checked[nr][nc]){
                    if(nr==R-1 && nc==C-1){
                        return d+1;
                    }
                    q.offer(new int[]{nr,nc,d+1});
                    checked[nr][nc]=true;
                }
            }
        }
        return -1;
    }
}
