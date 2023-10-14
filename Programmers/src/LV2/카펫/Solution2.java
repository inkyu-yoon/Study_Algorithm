package LV2.카펫;

class Solution2 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        for(int w=1;w<=total;w++){
            if(total%w==0){
                int h = total/w;
                if(h<=w && 2*(w+h)-4==brown){
                    answer[0]=w;
                    answer[1]=h;
                }
            }
        }


        return answer;
    }
}
