package LV2.다음큰숫자;

class Solution2 {
    public int solution(int n) {
        int answer = 0;
        int numOfOne = getNum(n);

        for(int i=n+1;i<=1000000;i++){
            if(numOfOne == getNum(i)){
                answer = i;
                break;
            }
        }


        return answer;
    }

    private int getNum(int n){
        int cnt = 0;
        String s = Integer.toBinaryString(n);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                cnt++;
            }
        }

        return cnt;
    }
}