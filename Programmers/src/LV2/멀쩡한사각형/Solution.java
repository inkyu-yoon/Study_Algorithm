package LV2.멀쩡한사각형;

// 가로 W 세로 H
// 대각선 꼭지점 2개를 잇는 방향으로 자름
// 사용할 수 있는 정사각형의 개수를 구하라

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        for(int x=1;x<=w;x++){
            answer+=f(x,w,h);
        }
        return answer*2;
    }

    int f(int x,int w, int h){
        return (int)Math.floor(((double)(-h)/w*x)+h);
    }
}