package LV2.이진변환반복하기;

class Solution2 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        System.out.println(Integer.toBinaryString(4));

        while (!s.equals("1")) {
            answer[1] += getNumOfZero(s);
            s = s.replace("0", "");

            int len = s.length();
            s = Integer.toBinaryString(len);
            answer[0]++;
        }

        return answer;
    }

    private int getNumOfZero(String s) {
        int N = s.length();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '0') {
                cnt++;
            }
        }
        return cnt;
    }
}