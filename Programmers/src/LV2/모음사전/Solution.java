package LV2.모음사전;

import java.util.*;
class Solution {
    String [] words = {"A","E","I","O","U"};
    StringBuilder sb;
    List<String> list;

    public int solution(String word) {
        sb = new StringBuilder();
        list = new ArrayList<>();
        for(int i=1;i<=5;i++){
            bt(i);
        }

        Collections.sort(list);

        return list.indexOf(word)+1;
    }

    void bt(int size){
        if(sb.length()==size){
            list.add(sb.toString());
            return;
        }
        for(int i=0;i<words.length;i++){
            sb.append(words[i]);
            bt(size);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}