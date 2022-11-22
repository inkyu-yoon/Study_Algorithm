package 해시.전화번호목록;

import java.util.*;

class Solution {
    //어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 출력
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,Integer> numbers = new HashMap<>();

        //전화번호 부 모든 번호를 Map에 저장
        for(String phone : phone_book){
            numbers.put(phone,1);
        }

        //전화번호부에 있는 전화번호를 쪼개서 map에 저장되어있는지 확인
        for(String number : numbers.keySet()){
            //0이상 1 ~ length-1미만 까지 쪼개봐야한다.
            for(int i=1;i<=number.length()-1;i++){
                //쪼갠 번호가 map에 저장되어 있는 경우, 접두어가 되는 번호가 존재한다는 의미
                if(numbers.containsKey(number.substring(0,i))){
                    return false;
                }
            }
        }
        return answer;
    }
}