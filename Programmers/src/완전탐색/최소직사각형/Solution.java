package 완전탐색.최소직사각형;

import java.util.*;
class Solution {
    //모든 명함을 수납할 수 있는 지갑의 크기
    public int solution(int[][] sizes) {

        int max = Math.max(sizes[0][0],sizes[0][1]);
        int min = Math.min(sizes[0][0],sizes[0][1]);

        for(int i=1;i<sizes.length;i++){
            int[] card = sizes[i];
            int targetMax = Math.max(card[0],card[1]);
            int targetMin = Math.min(card[0],card[1]);

            if(targetMax>max){
                max = targetMax;
            }

            if(targetMin>min){
                min = targetMin;
            }

        }

        System.out.println("max: "+max);
        System.out.println("min: "+min);

        return max*min;
    }
}