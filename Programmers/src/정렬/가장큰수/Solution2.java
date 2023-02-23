package 정렬.가장큰수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2 {
    //정수를 이어 붙여 만들 수 있는 가장 큰 수 알아내기
    public String solution(int[] numbers) {

        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();

        for(int number : numbers){
            list.add(String.valueOf(number));
        }

        Collections.sort(list,(a,b)->(b+a).compareTo(a+b));

        for(String number : list){
            sb.append(number);
        }

        String answer = sb.toString();
        if(answer.startsWith("0")){
            return "0";
        }else{
            return answer;
        }
    }
}
