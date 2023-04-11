package LV2.다음큰숫자;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int numOfOne = countOne(n);

        while(true){
            if(numOfOne==countOne(++n)){
                break;
            }
        }
        return n;
    }

    int countOne(int n){
        String s = Integer.toBinaryString(n);
        int numOfOne = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                numOfOne++;
            }
        }
        return numOfOne;
    }
}