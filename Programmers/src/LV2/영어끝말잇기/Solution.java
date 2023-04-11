package LV2.영어끝말잇기;

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();

        char end = words[0].charAt(words[0].length()-1);

        set.add(words[0]);

        for(int i=1;i<words.length;i++){
            String text = words[i];
            char start = text.charAt(0);

            if(end == start && !set.contains(words[i])){
                end = text.charAt(text.length()-1);
                set.add(words[i]);
            }else{
                return new int[]{(i%n)+1,(i/n)+1};
            }
        }
        return new int[]{0,0};
    }
}