package LV2.큰수만들기;

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int[] arr = Arrays.stream(number.split("")).mapToInt(Integer::valueOf).toArray();

        Stack<Integer> s = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(s.isEmpty()){
                s.push(arr[i]);
            }else{
                if(s.peek()>=arr[i]){
                    s.push(arr[i]);
                }else{
                    while(!s.isEmpty() && s.peek()<arr[i] && k!=0){
                        s.pop();
                        k--;
                    }
                    s.push(arr[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.size()-k;i++){
            sb.append(s.get(i));
        }

        return sb.toString();
    }
}