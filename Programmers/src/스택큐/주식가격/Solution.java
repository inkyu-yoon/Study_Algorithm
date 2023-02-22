package 스택큐.주식가격;

import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i<answer.length-1;i++){
            int sec = 0;
            for(int j=i+1;j<answer.length;j++){
                sec++;
                if(prices[j]<prices[i]){
                    break;
                }
            }
            answer[i]=sec;
        }

        return answer;
    }
}