package LV2.프랜즈4블록;

import java.util.*;
class Solution {
    String[][] map;
    boolean[][] checked;
    int R;
    int C;
    int[] dr = {1,1,0};
    int[] dc = {0,1,1};
    int answer;
    public int solution(int m, int n, String[] board) {
        answer = 0;
        setUp(m,n,board);

        while(findTarget()){
            removeTarget();
            move();
        }

        return answer;
    }

    void move(){
        for(int c = 0;c<C;c++){
            StringBuilder sb = new StringBuilder();
            for(int r=R-1;r>=0;r--){
                if(!map[r][c].equals("0")){
                    sb.append(map[r][c]);
                }
            }
            while(sb.length()<R){
                sb.append("0");
            }
            for(int r=0;r<R;r++){
                map[R-1-r][c]=String.valueOf(sb.charAt(r));
            }
        }
    }

    void removeTarget(){
        for(int r=0;r<R;r++){
            for(int c =0;c<C;c++){
                if(checked[r][c]){
                    map[r][c]="0";
                    answer++;
                }
            }
        }
    }

    boolean findTarget(){
        boolean result = false;
        checked = new boolean[R][C];
        for(int r=0;r<R-1;r++){
            for(int c =0;c<C-1;c++){
                if(!map[r][c].equals("0") && canRemove(r,c)){
                    result = true;
                    checked[r][c]=true;
                    for(int i=0;i<3;i++){
                        checked[r+dr[i]][c+dc[i]]=true;
                    }
                }
            }
        }
        return result;
    }

    boolean canRemove(int r, int c){
        String target = map[r][c];
        for(int i=0;i<3;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(!map[nr][nc].equals(target)){
                return false;
            }
        }
        return true;
    }

    void setUp(int m, int n, String[] board){
        R = m;
        C = n;
        map = new String[R][C];

        for(int r=0;r<R;r++){
            String [] info = board[r].split("");
            for(int c=0;c<C;c++){
                map[r][c]=info[c];
            }
        }
    }
}
