package 정렬.가장큰수;

import java.util.*;
class Solution {
    //정수를 이어 붙여 만들 수 있는 가장 큰 수 알아내기
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        //문자열을 기준으로 정렬을 해야할 것
        List<String> list = new ArrayList<>();

        //int 배열 원소들을 String으로 바꾼 뒤 리스트에 저장
        for(Integer number : numbers){
            list.add(String.valueOf(number));
        }

        //내림차순으로 정렬해야함
        //a.compareTo(b) 인 경우, a가 더 크면 1 반환하므로 위치를 바꿈
        Collections.sort(list, (a,b)-> (b+a).compareTo(a+b));

        //내림차순 정렬 뒤 더해주면 정답
        for(String element : list){
            sb.append(element);
        }

        // 배열이 [0,0,0] 으로 주어졌을 때, "000" 이 아닌 "0" 으로 반환해야함
        if(sb.toString().charAt(0)=='0'){
            return "0";
        }


        return sb.toString();
    }
}
