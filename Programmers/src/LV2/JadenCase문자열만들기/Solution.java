package LV2.JadenCase문자열만들기;

// 첫 문자는 대문자 그외는 소문자
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        // 전체 소문자로 변경
        s = s.toLowerCase();

        //앞글자만 대문자로 변환
        for(int i=0;i<s.length();i++){
            char text = s.charAt(i);
            if(i==0){
                if(isAlpha(text)){
                    sb.append(String.valueOf(text).toUpperCase());
                }else{
                    sb.append(text);
                }
            }else{
                if(s.charAt(i-1)==' '){
                    if(isAlpha(text)){
                        sb.append(String.valueOf(text).toUpperCase());
                    }else{
                        sb.append(text);
                    }
                }else{
                    sb.append(text);
                }
            }
        }
        return sb.toString();
    }

    boolean isAlpha(char text){
        if('a'<=text & text<='z'){
            return true;
        }

        return false;
    }

}