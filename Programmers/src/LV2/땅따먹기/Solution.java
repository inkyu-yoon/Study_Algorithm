package LV2.땅따먹기;


import java.util.*;
class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];

        for(int i=0;i<land.length;i++){
            for(int j=0;j<4;j++){
                if(i==0){
                    dp[i][j]=land[i][j];
                }else{
                    for(int k=0;k<4;k++){
                        if(j==k){
                            continue;
                        }
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][k]+land[i][j]);
                    }
                }
            }
        }

        return Arrays.stream(dp[land.length-1])
                .max()
                .getAsInt();
    }
}