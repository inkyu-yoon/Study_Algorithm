package 문자열.JadenCase문자열만들기;

class Solution {
    //모든 단어의 첫 문자가 대문자이다. 그 외 알파벳은 모두 소문자이다.
    //시작을 숫자로 한다면? 뒤 문자들은 다 소문자로 쓴다.
    public String solution(String s) {

        StringBuilder answer = new StringBuilder();
        //먼저, 모든 문자열을 소문자로 바꾼다.
        s = s.toLowerCase();

        //제일 첫 문자가 숫자면 그대로
        if (isNum(s.charAt(0))) {
            answer.append(s.charAt(0));
        //제일 첫 문자가 알파벳이면 대문자로 변환
        } else {
            answer.append((char) (s.charAt(0) - 'a' + 'A'));
        }

        // 첫문자 체크는 위에서 진행했으므로, index 1부터 체크
        for (int i = 1; i < s.length(); i++) {
            //이전에 나온 문자가 공백이고, 현재 위치가 공백이 아니라면 단어의 시작점이다.
            if (s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') {
                //단어 시작이 숫자면 그대로, 문자면 변환한다.
                if (isNum(s.charAt(i))) {
                    answer.append(s.charAt(i));
                } else {
                    answer.append((char) (s.charAt(i) - 'a' + 'A'));
                }
                //공백을 포함한 다른 문자들은 변환할 필요가 없다.
            } else {
                answer.append(s.charAt(i));
            }
        }

        return answer.toString();
    }
    static boolean isNum(char ch){
        return ('0'<=ch && ch<='9')?true:false;
    }
}