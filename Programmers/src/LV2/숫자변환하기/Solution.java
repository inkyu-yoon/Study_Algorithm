package LV2.숫자변환하기;

//x를 y로 변환하는데 필요한 최소 연산 횟수
// *2 *3 +n 가능
import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {

        int[] dp = new int[(y+1)*3];
        for(int i=0;i<=y;i++){
            dp[i]=Integer.MAX_VALUE;
        }

        dp[x]=0;

        for(int i=x;i<=y;i++){
            if(dp[i]==Integer.MAX_VALUE){
                continue;
            }
            dp[i*2] = Math.min(dp[i]+1,dp[i*2]);
            dp[i*3] = Math.min(dp[i]+1,dp[i*3]);
            dp[i+n] = Math.min(dp[i]+1,dp[i+n]);
        }

        return dp[y]==Integer.MAX_VALUE? -1 : dp[y] ;
    }
}