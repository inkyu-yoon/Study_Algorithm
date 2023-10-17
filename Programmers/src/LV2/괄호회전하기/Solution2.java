package LV2.괄호회전하기;

import java.util.*;
class Solution2 {
    Set<Character> open = new HashSet<>(List.of('{','[','('));
    public int solution(String s) {
        int answer = 0;
        String str = s+s;
        int N = s.length();
        for(int i=0;i<N;i++){
            if(isRight(str.substring(i,i+N))){
                answer++;
            }
        }
        return answer;
    }

    private boolean isRight(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(stack.isEmpty() || open.contains(ch)){
                stack.push(ch);
            }else{
                if(ch==']'){
                    if(stack.peek()!='['){
                        return false;
                    }else{
                        stack.pop();
                    }
                }else if(ch==')'){
                    if(stack.peek()!='('){
                        return false;
                    }else{
                        stack.pop();
                    }
                }else if(ch=='}'){
                    if(stack.peek()!='{'){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }

        }

        return stack.isEmpty();


    }
}