package LV2.거리두기확인하기;

import java.util.*;
class Solution {
    String[][] map;
    boolean[][] checked;
    Queue<int[]> q;
    int[] dr = {1,-1,0,0};
    int[] dc= {0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer,1);

        for(int i=0;i<places.length;i++){
            setMap(places[i]);

            boolean flag = false;

            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(map[j][k].equals("P")){
                        q = new LinkedList<>();
                        checked = new boolean[5][5];
                        q.offer(new int[]{j,k,0});
                        int result = bfs();
                        if((0<result&&result<=2)){
                            flag = true;
                        }
                    }
                }
            }
            if(flag){
                answer[i]=0;
            }
        }
        return answer;
    }

    int bfs(){
        while(!q.isEmpty()){
            int[] point = q.poll();
            int r=point[0];
            int c=point[1];

            int dist=point[2];
            checked[r][c]=true;

            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(0<=nr&&nr<5&&0<=nc&&nc<5&&!checked[nr][nc]&&!map[nr][nc].equals("X")){
                    q.offer(new int[]{nr,nc,dist+1});
                    if(map[nr][nc].equals("P")){
                        return dist+1;
                    }
                }
            }
        }
        return -1;

    }

    void setMap(String[] place){
        map = new String[5][5];

        for(int r=0;r<5;r++){

            String[] info = place[r].split("");

            for(int c=0;c<5;c++){
                map[r][c]=info[c];
            }

        }
    }
}