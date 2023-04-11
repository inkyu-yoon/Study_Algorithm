package LV2.올바른괄호;

class Solution {
    boolean solution(String s) {
        int answer = 0;

        for(int i=0;i<s.length();i++){
            char target = s.charAt(i);
            if(answer==0){
                if(target==')'){
                    return false;
                }
                else{
                    answer++;
                }
            }else{
                if(target==')'){
                    answer--;
                }
                else{
                    answer++;
                }
            }
        }

        if(answer==0){
            return true;
        }else{
            return false;
        }
    }
}