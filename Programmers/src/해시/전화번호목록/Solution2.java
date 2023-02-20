package 해시.전화번호목록;

import java.util.*;
class Solution2 {
    // 한 번호가 다른 번호의 접두어인 경우가 있는가?
    // 접두어가 되는 경우가 있는 경우 false 반환
    // 같은 전화번호가 중복해서 들어있지 않다.
    // phone_book의 길이는 1이상 1,000,000이하
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }

        return answer;
    }
}