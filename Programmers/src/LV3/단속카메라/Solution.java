package LV3.단속카메라;

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();

        for(int[] route : routes){
            list.add(route);
        }

        Collections.sort(list,(a,b)->a[0]-b[0]);
        int camera = Integer.MIN_VALUE;
        for(int[] arr : list){
            if(arr[0]>camera){
                camera = arr[1];
                answer++;
            }

            if(arr[1]<camera){
                camera=arr[1];
            }
        }

        return answer;
    }
}

// -20      -15 |    -5    -3
//      -17-16
//            -14    -5
//    -18       -13