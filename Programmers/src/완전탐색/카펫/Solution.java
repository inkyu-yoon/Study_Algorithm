package 완전탐색.카펫;

public class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int total = brown + yellow;

        for (int height = 1; height <= total; height++) {

            if (total % height == 0) {

                int width = total / height;

                if (2 * height + 2 * width - 4 == brown && height <= width) {
                    answer = new int[]{width, height};
                }
            }
        }

        return answer;
    }

}
