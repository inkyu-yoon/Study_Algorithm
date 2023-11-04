package LV3.등굣길;

class Solution2 {
    public int solution(int m, int n, int[][] puddles) {
        int R = m+1,C=n+1;
        int[][] map = new int[R][C];
        map[1][1]=1;
        for(int[] puddle : puddles){
            map[puddle[0]][puddle[1]]=-1;
        }

        for(int r = 1;r<R;r++){
            for(int c=1;c<C;c++){
                if(map[r][c]==-1){
                    continue;
                }

                if(map[r-1][c]!=-1){
                    map[r][c]+=map[r-1][c];
                }

                if(map[r][c-1]!=-1){
                    map[r][c]+=map[r][c-1];
                }

                map[r][c]%=1000000007;

            }
        }

        return map[R-1][C-1]%1000000007;
    }
}
