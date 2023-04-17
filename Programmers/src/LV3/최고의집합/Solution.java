package LV3.최고의집합;

// 각 원소의 합이 s 원소의 곱이 최대
// 자연수 n개로 이루어짐
import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int idx = 0;
        do{
            int num = s/n--;
            if(num==0){
                return new int[]{-1};
            }
            answer[idx++]=num;
            s-=num;
        }while(n>0);

        return answer;
    }
}