package LV2.점프와순간이동;

import java.util.*;
// 점프한 칸 수 만큼 건전지 사용
// 현재까지 온 거리의 2배에 해당하는 위치로 이동 (건전지 사용 없이 가능)

public class Solution2 {
    public int solution(int n) {
        int cnt = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                cnt++;
            }
        }

        return cnt;
    }
}