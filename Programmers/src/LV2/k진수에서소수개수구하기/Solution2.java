package LV2.k진수에서소수개수구하기;

import java.util.*;

class Solution2 {
    public int solution(int n, int k) {
        int answer = 0;
        String value = convert(n, k);
        System.out.println(value);
        String[] arr = value.split("0");

        for (String num : arr) {
            if (num.length() == 0 || num.equals("1")) {
                continue;
            }
            if (isPrime(num)) {
                answer++;
            }


        }
        return answer;
    }

    private String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPrime(String num) {

        Long n = Long.parseLong(num);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}