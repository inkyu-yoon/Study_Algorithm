package LV2.큰수만들기;

import java.util.*;
class Solution2 {
    public String solution(String number, int k) {
        int[] arr = Arrays.stream(number.split("")).mapToInt(Integer::valueOf).toArray();

        Stack<Integer> s = new Stack<>();
        int count = k;
        for(int i=0;i<arr.length;i++){
            if(s.isEmpty()){
                s.push(arr[i]);
            }else{
                if(s.peek()>=arr[i]){
                    s.push(arr[i]);
                }else{
                    while(!s.isEmpty() && s.peek()<arr[i] && count!=0){
                        s.pop();
                        count--;
                    }
                    s.push(arr[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.size()-count;i++){
            sb.append(s.get(i));
        }

        return sb.toString();
    }
}
