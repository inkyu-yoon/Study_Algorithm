package LV2.최솟값만들기;

import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = A.length;

        while(i-->0){
            answer+=A[i]*B[B.length-i-1];
        }

        return answer;
    }
}
