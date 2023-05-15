package LV2.점찍기;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int x=0;x<=d;x+=k){
            answer+=(int)getY(x,d)/k + 1;
        }
        return answer;
    }

    double getY(int x,int d){
        return Math.sqrt(Math.pow(d,2)-Math.pow(x,2));
    }
}
