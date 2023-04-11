package LV2.N개의최소공배수;

class Solution {

    public int solution(int[] arr) {

        int answer = arr[0];

        for(int i=1;i<arr.length;i++){
            answer=answer*arr[i]/getGCD(answer,arr[i]);
        }
        return answer;
    }

    int getGCD(int a, int b){
        while(b!=0){
            int temp = b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}