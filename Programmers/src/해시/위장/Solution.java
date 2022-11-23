package 해시.위장;

import java.util.*;

class Solution {
    //스파이는 매일 다른 옷을 조합하여 입는다.
    // [의상 이름 , 의상 종류 ] 같은 의상 종류는 1개만 착용
    // 최소 1개의 의상 종류를 입어야 함
    static Map<String, Integer> styles = new HashMap<>();

    public int solution(String[][] clothes) {
        int answer = 1;


        // 의상 종류를 key 값으로 하고, 갯수를 입력한다.
        // 이미 존재하는 의상 종류일 경우 갖고 있는 value 값에 +1을 한다.
        for(String[] cloth : clothes){
            if(styles.containsKey(cloth[1])){
                styles.put(cloth[1],styles.get(cloth[1])+1);
            }else{
                styles.put(cloth[1],1);
            }
        }

        //모든 경우의 수는 의상의 종류 + 1(의상을 안입는 선택도 경우의 수에 포함)
        for(String key : styles.keySet()){
            answer *=styles.get(key)+1;
        }

        //다 안입는 경우의 수 1개는 제외 시켜야 함
        answer -=1;

        return answer;
    }


}
