package LV2.HIndex;

class Solution2 {
    public int solution(int[] citations) {
        int answer = 0;
        for (int h = 0; h <= 10000; h++) {
            int cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= h) {
                    cnt++;
                }

                if (cnt == h) {
                    answer = h;
                    break;
                }
            }
        }
        return answer;
    }
}
