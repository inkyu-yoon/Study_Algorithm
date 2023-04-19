package LV3.단어변환;

import java.util.*;
class Solution {
    Stack<String> stack;
    boolean[] checked;
    String ans;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        stack = new Stack<>();
        checked = new boolean[words.length];
        ans = target;
        stack.push(begin);

        bt(words);

        if(answer == Integer.MAX_VALUE){
            return 0;
        }else{
            return answer;
        }
    }

    void bt(String[] words){
        if(stack.peek().equals(ans)){
            answer = Math.min(answer,stack.size()-1);
            return;
        }
        for(int i=0;i<checked.length;i++){
            String word = words[i];
            if(checked[i] || !checkWord(word)){
                continue;
            }
            stack.push(word);
            checked[i]=true;
            bt(words);
            stack.pop();
            checked[i]=false;
        }
    }

    boolean checkWord(String word){
        String previous = stack.peek();
        int num = 0;
        for(int i=0;i<word.length();i++){
            if(previous.charAt(i)!=word.charAt(i)){
                num++;
            }
            if(num==2){
                return false;
            }
        }

        if(num==1){
            return true;
        }else{
            return false;
        }
    }
}