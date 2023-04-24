package LV3.스티커모으기2;

import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        if(sticker.length<=3){
            return Arrays.stream(sticker)
                    .max()
                    .getAsInt();
        }

        int[]dp = new int[sticker.length-1];
        int[]dp2 = new int[sticker.length-1];
        dp[0]=sticker[0];
        dp[1]=sticker[1];
        dp[2]=sticker[2]+dp[0];
        dp2[0]=sticker[1];
        dp2[1]=sticker[2];
        dp2[2]=sticker[3]+dp2[0];
        for(int i=3;i<sticker.length-1;i++){
            dp[i]=Math.max(Math.max(sticker[i]+dp[i-2],dp[i-1]),dp[i-3]+sticker[i]);
            dp2[i]=Math.max(Math.max(sticker[i+1]+dp2[i-2],dp2[i-1]),dp2[i-3]+sticker[i+1]);
        }
        return Math.max(dp[sticker.length-2],dp2[sticker.length-2]);
    }
}