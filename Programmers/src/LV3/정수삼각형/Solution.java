package LV3.정수삼각형;

import java.util.*;
class Solution {
    public int solution(int[][] triangle) {

        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0]=triangle[0][0];

        for(int r=1;r<triangle.length;r++){
            for(int c = 0;c<=r;c++){
                if(c==0){
                    dp[r][c]=dp[r-1][c]+triangle[r][c];
                }else if(c==r){
                    dp[r][c]=dp[r-1][c-1]+triangle[r][c];
                }else{
                    dp[r][c]= Math.max(dp[r-1][c-1],dp[r-1][c]) + triangle[r][c];
                }
            }
        }

        return Arrays.stream(dp[triangle.length-1])
                .max()
                .getAsInt();
    }
}