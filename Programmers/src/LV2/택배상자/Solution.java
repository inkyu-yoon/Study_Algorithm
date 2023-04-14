package LV2.택배상자;

import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();

        int main = 1;
        for(int i=0;i<order.length;i++){
            int target = order[i];
            if(!s.contains(target)){
                while(main!=target){
                    s.push(main++);
                }
                main++;
            }else{
                if(s.peek()!=target){
                    break;
                }else{
                    s.pop();
                }
            }
            answer = i+1;
        }
        return answer;
    }
}
