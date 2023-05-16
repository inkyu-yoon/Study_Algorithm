package LV3.경주로건설;
import java.util.*;
class Solution {
    int N;
    int[][][] checked;
    Queue<int[]> q;
    int [] dr = {1,-1,0,0};
    int [] dc = {0,0,1,-1};
    public int solution(int[][] board) {
        setUp(board);
        bfs(board);
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            answer = Math.min(checked[i][N-1][N-1],answer);
        }
        return answer;
    }
    void bfs(int[][] board){
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

                if(0<=nr && nr<N && 0<=nc && nc<N && board[nr][nc]!=1){
                    if(checked[i][nr][nc] > ncost){
                        q.offer(new int[]{nr,nc,ncost,i});
                        checked[i][nr][nc]=ncost;
                    }
                }

            }
        }
    }

    void setUp(int[][] board){
        N = board.length;
        checked = new int[4][N][N];

        for(int[][] array : checked){
            for(int[] arr : array){
                Arrays.fill(arr,Integer.MAX_VALUE);
            }
        }

        for(int i=0;i<4;i++){
            checked[i][0][0]=0;
        }

        q = new LinkedList<>();

        if(board[0][1]!=1){
            // r c cost dir
            q.offer(new int[]{0,1,100,2});
            checked[2][0][1]=100;
        }

        if(board[1][0]!=1){
            // r c cost dir
            q.offer(new int[]{1,0,100,0});
            checked[0][1][0]=100;
        }

    }
}