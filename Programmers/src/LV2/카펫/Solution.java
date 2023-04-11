package LV2.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        for(int h=3;h<=total;h++){
            if(total%h==0){
                int w = total/h;
                if(2*(w+h)-4==brown){
                    return new int[]{w,h};
                }
            }
        }
        return answer;
    }
}