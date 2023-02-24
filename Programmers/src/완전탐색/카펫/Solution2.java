package 완전탐색.카펫;

public class Solution2 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int totalNum = brown + yellow;

        for(int h = 3;h*h<=totalNum;h++){
            if(totalNum%h==0){
                int w = totalNum/h;
                if(brown==(2*w+2*h-4)){
                    answer[0]=w;
                    answer[1]=h;
                }
            }
        }

        return answer;
    }

}
