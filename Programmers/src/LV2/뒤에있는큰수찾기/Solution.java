package LV2.뒤에있는큰수찾기;

import java.util.*;
class Solution {
    Stack<Integer> stack;
    int[] answer;
    public int[] solution(int[] numbers) {
        setUp(numbers.length);
        for(int idx=0;idx<numbers.length;idx++){
            if(stack.isEmpty()){
                stack.push(idx);
            }else{
                while(!stack.isEmpty()&&numbers[stack.peek()]<numbers[idx]){
                    answer[stack.pop()]=numbers[idx];
                }
                stack.push(idx);
            }
        }
        return answer;
    }

    void setUp(int size){
        stack = new Stack<>();
        answer  = new int[size];
        for(int i=0;i<size;i++){
            answer[i]=-1;
        }
    }
}
