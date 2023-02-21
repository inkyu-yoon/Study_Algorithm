package 스택큐.올바른괄호;
import java.util.*;
class Solution {
    // 괄호가 잘 닫혔는지, 잘 닫혔으면 true
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }else{
                // "(" 가 들어오기전에 ")"가 들어온 경우
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        //괄호가 짝을 이루지 않았다면, stack 크기가 0이 아닐것
        if(!stack.isEmpty()){
            return false;
        }

        return answer;
    }
}