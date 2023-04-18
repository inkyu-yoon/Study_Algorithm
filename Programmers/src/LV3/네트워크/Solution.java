package LV3.네트워크;

import java.util.*;
class Solution {
    Stack<int[]> stack;
    boolean[][] checked;
    int[][] network;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        stack = new Stack<>();
        checked = new boolean[n][n];
        network = computers;

        for(int r = 0 ; r<n;r++){
            for(int c =0;c<n;c++){
                if(!checked[r][c] && network[r][c]==1){
                    stack.push(new int[]{r,c});
                    checked[r][c]=true;
                    dfs();
                    answer++;
                }
            }
        }
        return answer;
    }

    void dfs(){
        while(!stack.isEmpty()){
            int [] info = stack.pop();
            int r = info[0];
            int c = info[1];

            for(int i=0;i<network.length;i++){
                if(!checked[r][i] && network[r][i]==1){
                    stack.push(new int[]{r,i});
                    checked[r][i]=true;
                    if(!checked[i][r]){
                        stack.push(new int[]{i,r});
                        checked[i][r]=true;
                    }
                }
            }
        }
    }
}
