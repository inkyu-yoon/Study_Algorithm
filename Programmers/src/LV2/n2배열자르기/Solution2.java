package LV2.n2배열자르기;

class Solution2 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        int idx = 0;

        for (long i = left; i <= right; i++) {
            answer[idx++] = Math.max((int) (i % n), (int) (i / n)) + 1;
        }

        return answer;
    }
}
