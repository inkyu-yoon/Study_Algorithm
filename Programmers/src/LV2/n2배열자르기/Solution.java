package LV2.n2배열자르기;

import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {

        List<Integer> list = new ArrayList<>();

        long num = (long) n;

        for(long i = left;i<=right;i++){
            list.add((int)(Math.max(i%num,i/num)+1));
        }



        return list.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}