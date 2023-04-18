package LV2.k진수에서소수개수구하기;

import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String num = transform(n,k);
        Pattern pattern = Pattern.compile("[1-9]+");
        Matcher matcher = pattern.matcher(num);
        while(matcher.find()){
            String target = matcher.group();
            if(isPrime(Long.parseLong(target))){
                answer++;
            }
        }
        return answer;
    }

    boolean isPrime(long num){
        if(num==1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    String transform(int num,int k){
        StringBuilder result = new StringBuilder();
        while(num!=0){
            result.append(num%k);
            num/=k;
        }
        return result.reverse().toString();
    }
}
