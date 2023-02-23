package 정렬.HIndex;

import java.util.Arrays;

class Solution2 {
    //발표한 논문 n개중, h번 이상 인용된 논문이 h편 이상일 때 H-index가 될 수 있다.
    // 그 중 최댓값을 찾으면 된다.
    public int solution(int[] citations) {
        int answer = 0;

        // 배열의 길이보다 큰 원소가 있어도, 그 값만큼 원소가 존재할 수 없기 때문에
        // H-index 최댓값은 배열의 길이
        int max = citations.length;

        for (int i = max; i >= 0; i--) {

            int count = 0;

            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    count++;
                }
            }

            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}