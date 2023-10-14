package LV2.최댓값과최솟값;

import java.util.*;
class Solution2 {
    public String solution(String s) {
        String answer = "";
        int[] arr = getArr(s);

        Arrays.sort(arr);

        return arr[0]+" "+arr[arr.length-1];
    }

    private int[] getArr(String s){
        String[] arr = s.split(" ");
        int N = arr.length;
        int[] result = new int[N];

        for(int i=0; i<N;i++){
            result[i] = Integer.parseInt(arr[i]);
        }

        return result;

    }
}
