package LV2.행렬테두리회전하기;

import java.util.*;
class Solution {
    int[][] arr;
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};
    List<Integer> ans = new ArrayList<>();
    public int[] solution(int rows, int columns, int[][] queries) {
        setUp(rows,columns);
        for(int[] query : queries){
            rotate(query);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    void rotate(int [] info){
        int x1 = info[0]-1, y1 = info[1]-1;
        int x2 = info[2]-1, y2 = info[3]-1;
        int r = x1, c = y1;
        int dir = 0;
        int previous = arr[r+1][c];
        int min = previous;
        while(true){
            int temp = arr[r][c];
            min = Math.min(min,temp);
            arr[r][c]=previous;
            previous = temp;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr<x1 || nr > x2 || nc < y1 || nc > y2){
                dir = (dir+1)%4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            r = nr;
            c = nc;
            if(r==x1 && c==y1){
                break;
            }
        }
        ans.add(min);
    }

    void setUp(int r, int c){
        arr = new int[r][c];
        int num =1;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=num++;
            }
        }
    }
}