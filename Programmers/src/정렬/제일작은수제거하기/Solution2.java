package 정렬.제일작은수제거하기;

import java.util.*;
class Solution2 {
    public int[] solution(int[] arr) {
        //원소 1개인 경우
        if(arr.length==1){
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();

        int[] answer = new int[arr.length-1];

        int index =0;

        for(int num : arr){
            if(num==min) continue;
            answer[index++]=num;
        }

        return answer;
    }
}