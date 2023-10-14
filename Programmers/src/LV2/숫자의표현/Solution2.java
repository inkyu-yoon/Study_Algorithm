package LV2.숫자의표현;

class Solution2 {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int left = 0, right = 0;

        while (left <= right && right <= n) {
            if (sum > n) {
                sum -= left++;
            } else if (sum < n) {
                sum += ++right;
            } else {
                answer++;
                sum += ++right;
            }
        }

        return answer;
    }
}