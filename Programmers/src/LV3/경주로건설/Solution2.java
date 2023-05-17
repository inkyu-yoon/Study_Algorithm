package LV3.경주로건설;
import java.util.*;
class Solution2 {
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] checked = new int[4][N][N];
        Queue<int[]> q = new LinkedList<>();
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        for(int[][] arr: checked){
            for(int[] ar : arr){
                Arrays.fill(ar,Integer.MAX_VALUE);
            }
        }

        for(int i=0;i<4;i++){
            checked[i][0][0]=0;
        }

        if(board[0][1]!=1){
            q.offer(new int[]{0,1,100,2});
            checked[2][0][1]=100;
        }

        if(board[1][0]!=1){
            q.offer(new int[]{1,0,100,0});
            checked[0][1][0]=100;
        }

        while(!q.isEmpty()){
            int[] info = q.poll();
            int r = info[0], c = info[1];
            int cost = info[2], dir = info[3];

            for(int i=0;i<4;i++){
                int nr = dr[i] + r;
                int nc = dc[i] + c;
                int ncost = cost;

                if(dir!=i){
                    ncost+=600;
                }else{
                    ncost+=100;
                }

                if(0<=nr && nr <N && 0<=nc && nc<N && board[nr][nc]!=1){
                    if(checked[i][nr][nc]>ncost){
                        q.offer(new int[]{nr, nc, ncost, i});
                        checked[i][nr][nc]=ncost;
                    }
                }

            }

        }
        int ans = Integer.MAX_VALUE;
        for(int[][] arr : checked){
            ans = Math.min(ans,arr[N-1][N-1]);
        }
        return ans;
    }
}
