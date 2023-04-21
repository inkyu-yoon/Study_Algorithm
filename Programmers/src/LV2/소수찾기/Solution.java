package LV2.소수찾기;

import java.util.*;
class Solution {
    StringBuilder sb;
    String numbers;
    HashSet<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        this.numbers = numbers;
        sb = new StringBuilder();

        for(int i=1;i<=numbers.length();i++){
            bt(i);
        }

        for(int num : set){
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    boolean isPrime(int num){
        if(num==1 || num==0){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    void bt(int len){
        if(sb.length()==len){
            String result = "";
            for(int i=0;i<len;i++){
                result +=numbers.charAt(Integer.valueOf(""+sb.charAt(i)));
            }
            set.add(Integer.valueOf(result));
            return;
        }

        for(int i=0;i<numbers.length();i++){
            if(sb.indexOf(String.valueOf(i))>=0){
                continue;
            }
            sb.append(i);
            bt(len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}