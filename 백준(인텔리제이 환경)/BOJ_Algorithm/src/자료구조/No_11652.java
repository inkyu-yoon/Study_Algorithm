package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Map<Long, Integer> countMap = new HashMap<>();
        long key;

        //1. Map을 이용한 카운팅
        for (int i = 0; i < N; i++) {
            key = Long.valueOf(br.readLine());
            if (countMap.containsKey(key)) {
                countMap.put(key, countMap.get(key) + 1);
            }else{
                countMap.put(key, 1);
            }
        }


        //가장 많은 횟수로 입력된 수 && 최대 횟수가 같다면 크기가 작은 값 출력
        long maxKey =0L;  //최대로 많이 나온 값
        int maxTime = 0;  // 최대로 많이 나온 값의 횟수
        for (Long oneKey : countMap.keySet()) {
            if (countMap.get(oneKey) == maxTime) {
                if (oneKey < maxKey) {
                    maxKey = oneKey;
                }
            } else if (countMap.get(oneKey) > maxTime) {
                maxKey = oneKey;
                maxTime = countMap.get(oneKey);
            }
        }
        System.out.println(maxKey);
    }
}
