package LV2.피로도;

import java.util.*;
class Solution {
    Stack<Integer> stack;
    int answer;

    public int solution(int k, int[][] dungeons) {
        answer = -1;
        stack = new Stack<>();
        bt(dungeons,k);
        return answer;
    }

    void bt(int[][] dungeons,int k){
        if(stack.size()==dungeons.length){
            explore(dungeons,k);
            return;
        }
        for(int i=0;i<dungeons.length;i++){
            if(stack.indexOf(i)>=0){
                continue;
            }
            stack.push(i);
            bt(dungeons,k);
            stack.pop();
        }
    }

    void explore(int[][] dungeons,int energy){
        int result = 0;
        for(int i=0;i<stack.size();i++){
            int n = stack.get(i);
            int[] info = dungeons[n];
            int least = info[0];
            int waste = info[1];
            if(energy<least){
                break;
            }else{
                energy-=waste;
                result++;
            }
        }
        answer = Math.max(answer,result);
    }
}
