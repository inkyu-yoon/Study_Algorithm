package LV2.타겟넘버;

// 적절히 연산을 넣어서 target 이 되도록 만들기
import java.util.*;
class Solution {
    Stack<int[]> stack;

    public int solution(int[] numbers, int target) {
        stack = new Stack<>();
        return dfs(numbers,0,target);
    }

    int dfs(int[] numbers,int start,int target){
        int ans = 0;
        stack.push(new int[]{0,numbers[0]});
        stack.push(new int[]{0,-numbers[0]});
        while(!stack.isEmpty()){
            int[] info = stack.pop();
            int depth = info[0];
            int result = info[1];
            if(depth<numbers.length-1){
                stack.push(new int[]{depth+1,result+numbers[depth+1]});
                stack.push(new int[]{depth+1,result-numbers[depth+1]});
            }else if(depth==numbers.length-1){
                if(result==target){
                    ans++;
                }
            }
        }
        return ans;
    }
}