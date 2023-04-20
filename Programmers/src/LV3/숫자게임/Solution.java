package LV3.숫자게임;

import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int size = A.length;
        if(A[0]>B[size-1]){
            return 0;
        }

        int answer = 0,idxA = 0,idxB = 0;

        while(true){
            if(A[idxA]<B[idxB]){
                answer++;
                idxA++;
                idxB++;
            }else{
                idxB++;
            }
            if(idxA ==size || idxB==size){
                break;
            }
        }

        return answer;
    }
}