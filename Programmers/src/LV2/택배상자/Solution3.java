package LV2.택배상자;

import java.util.*;

class Solution3 {
    Stack<Integer> sub = new Stack<>();
    public int solution(int[] order) {
        int answer = 0;

        int cnt = 0;
        int box = 1;
        for(int i=0;i<order.length;i++){
            int target = order[i];

            if(box<=target){
                while(box!=target){
                    sub.push(box++);
                }
                if(box==target){
                    cnt++;
                    box++;
                }
            }else{
                if(!sub.isEmpty() && sub.peek()==target){
                    sub.pop();
                    cnt++;
                }else{
                    break;
                }
            }
        }

        return cnt;
    }
}
