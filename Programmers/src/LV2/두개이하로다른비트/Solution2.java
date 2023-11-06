package LV2.두개이하로다른비트;

class Solution2 {
    public long[] solution(long[] numbers) {
        int N = numbers.length;
        long[] answer = new long[N];
        int i = 0;
        for (long number : numbers) {
            String str = Long.toBinaryString(number);
            int idx = str.lastIndexOf("0");
            String result = "";
            if (idx != -1) {
                if (idx == str.length() - 1) {
                    result = str.substring(0, idx) + "1" + str.substring(idx + 1);
                } else {
                    result = str.substring(0, idx) + "10" + str.substring(idx + 2);
                }
            } else {
                result = "10" + str.substring(1);
            }
            answer[i++] = Long.parseLong(result, 2);
        }

        return answer;
    }
}
