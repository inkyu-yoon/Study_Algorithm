package LV2.택배상자;


import java.util.*;
class Solution2 {
    public int solution(int[] order) {
        int ans = order.length;
        Stack<Integer> stack = new Stack<>();
        int box = 1;

        for(int i=0;i<order.length;i++){
            if(stack.contains(order[i])){
                if(stack.peek()==order[i]){
                    stack.pop();
                }else{
                    ans=i;
                    break;
                }
            }else{
                while(box!=order[i]){
                    stack.push(box++);
                }
                box++;
            }
        }

        return ans;
    }
}
