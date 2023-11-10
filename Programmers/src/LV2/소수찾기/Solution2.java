package LV2.소수찾기;

import java.util.*;

class Solution2 {
    String[] split;
    boolean[] checked;
    StringBuilder sb = new StringBuilder();
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        split = numbers.split("");
        checked = new boolean[split.length];
        bt();
        int answer = 0;

        for (Integer n : set) {
            if (isPrime(n)) {
                answer++;
            }
        }

        return answer;
    }

    public void bt() {
        if (sb.length() != 0) {
            set.add(Integer.parseInt(sb.toString()));
        }
        if (sb.length() == split.length) {
            return;
        }

        for (int i = 0; i < split.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                sb.append(split[i]);
                bt();
                checked[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public boolean isPrime(int n) {
        if (n == 1 || n == 0) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
