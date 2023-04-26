package LV3.징검다리건너기;

import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {

        int left = Arrays.stream(stones).min().getAsInt();
        int right = Arrays.stream(stones).max().getAsInt();

        while(left<right){
            int mid = (left+right)/2;
            if(isPossible(mid,stones,k)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    boolean isPossible(int num,int[] stones,int k){
        int possible =0;
        for(int stone :stones){
            if(stone-num<=0){
                possible++;
            }else{
                possible = 0;
            }
            if(possible==k){
                return true;
            }
        }
        return false;

    }
}