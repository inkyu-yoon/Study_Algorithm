package LV2.숫자의표현;

class Solution {
    public int solution(int n) {

        int answer = 0;

        for(int i=1;i<=n;i++){

            int start= i;
            int result = 0;

            while(result<n){
                result+=start++;
            }

            if(result==n){
                answer++;
            }

        }

        return answer;
    }
}