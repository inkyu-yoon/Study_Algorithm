package LV3.기지국설치;

class Solution2 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int idx = 1;
        int last = -1;
        for (int station : stations) {
            int start = station - w;
            int end = station + w;
            last = end;
            int cnt = start - idx;
            if (cnt > 0) {
                answer += Math.ceil(cnt / (double) (w * 2 + 1));
            }
            idx = end + 1;
        }

        if (last < n) {
            answer += Math.ceil((n - last) / (double) (w * 2 + 1));
        }


        return answer;
    }
}