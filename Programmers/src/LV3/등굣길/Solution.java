package LV3.등굣길;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] dp = new long[m+1][n+1];
        dp[1][1]=1;

        for(int[] puddle : puddles){
            dp[puddle[0]][puddle[1]]=1;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1){
                    continue;
                }

                if(dp[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
                }
            }
        }
        return (int)dp[m][n]%1000000007;
    }
}