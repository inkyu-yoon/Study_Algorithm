package LV2.연속된부분수열의합;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int left = 0;
        int sum =0,length=Integer.MAX_VALUE;
        for(int i=0;i<sequence.length;i++){
            sum+=sequence[i];
            if(sum>k){
                while(sum>k){
                    sum-=sequence[left];
                    left++;
                }
            }

            if(sum==k && (i-left)<length){
                answer = new int[]{left,i};
                length = i-left;
            }
        }

        return answer;
    }
}