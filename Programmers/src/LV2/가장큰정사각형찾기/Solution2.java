package LV2.가장큰정사각형찾기;
class Solution2{
    public int solution(int [][]board){
        int ans = 0;
        int R = board.length;
        int C = board[0].length;
        int[][] map = new int[R+1][C+1];

        for(int r=1;r<R+1;r++){
            for(int c=1;c<C+1;c++){
                map[r][c]=board[r-1][c-1];
            }
        }

        for(int r=1;r<R+1;r++){
            for(int c=1;c<C+1;c++){
                if(map[r][c]!=0){
                    map[r][c]=Math.min(Math.min(map[r-1][c-1],map[r][c-1]),map[r-1][c])+1;
                    ans = Math.max(map[r][c],ans);
                }
            }
        }


        return ans*ans;
    }


}