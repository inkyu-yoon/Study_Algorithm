package LV2.주식가격;

import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1;i<prices.length;i++){
            if(prices[stack.peek()]<=prices[i]){
                stack.push(i);
            }else{
                do{
                    int idx = stack.pop();
                    answer[idx]= i-idx;

                }while(!stack.isEmpty() && prices[stack.peek()]>prices[i]);

                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length-idx-1;
        }

        return answer;
    }
}