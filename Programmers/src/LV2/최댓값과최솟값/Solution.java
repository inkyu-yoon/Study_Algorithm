package LV2.최댓값과최솟값;

import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";

        // int 배열로 변환
        int [] arr = Arrays.stream(s.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int max = Arrays.stream(arr)
                .max()
                .getAsInt();

        int min = Arrays.stream(arr)
                .min()
                .getAsInt();

        answer = String.format("%d %d",min,max);

        return answer;
    }
}