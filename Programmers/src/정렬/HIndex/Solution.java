package 정렬.HIndex;

import java.util.*;

class Solution {
    //발표한 논문 n개중, h번 이상 인용된 논문이 h편 이상일 때 H-index가 될 수 있다.
    // 그 중 최댓값을 찾으면 된다.
    public int solution(int[] citations) {
        int answer = 0;

        //인용 횟수 최댓값
        int max = Arrays.stream(citations).max().getAsInt();


        //인용 횟수 최댓값 부터 내려가면서 검증해본다.
        for (int i = max; i >= 0; i--) {

            //매 루프 마다 count 0으로 초기화
            int count = 0;

            // 인용횟수 이상인 것의 갯수를 세본다.
            for (int citation : citations) {
                if (citation >= i) {
                    count++;
                }
            }

            //인용 횟수 이상인 것의 갯수가 인용횟수 이상이면 H-index 조건 만족, 최댓값부터 탐색했으므로
            // 발견하면 바로 return한다.
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}