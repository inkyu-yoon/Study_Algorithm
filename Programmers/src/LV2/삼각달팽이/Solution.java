package LV2.삼각달팽이;

import java.util.*;
class Solution {
    int[][] snail;
    boolean[][] checked;
    int[] dr = {1,0,-1};
    int[] dc = {0,1,-1};

    public int[] solution(int n) {
        setUp(n);

        int r=0,c=0;
        int lastIdx = n*(n+1)/2;
        int idx=1,dir=0;

        while(idx<=lastIdx){
            snail[r][c]=idx++;
            checked[r][c]=true;
            int nr=r+dr[dir];
            int nc=c+dc[dir];
            if(nr<0 || nr==n || nc<0 || nc==n || checked[nr][nc]){
                dir=(dir+1)%3;
                nr=r+dr[dir];
                nc=c+dc[dir];
            }
            r=nr;
            c=nc;
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<snail.length;i++){
            for(int j=0;j<snail[i].length;j++){
                list.add(snail[i][j]);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    void setUp(int n){
        snail = new int[n][];
        checked = new boolean[n][];
        for(int i=1;i<=n;i++){
            snail[i-1]= new int[i];
            checked[i-1]=new boolean[i];

        }
    }
}