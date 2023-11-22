package LV2.호텔대실;

import java.util.*;

class Solution2 {
    public int solution(String[][] book_time) {
        int[] time = new int[24 * 60];
        for (String[] booking : book_time) {
            int startTime = convert(booking[0]);
            int endTime = convert(booking[1]);
            for (int i = startTime; i < endTime + 10 && i < 24 * 60; i++) {
                time[i]++;
            }
        }

        return Arrays.stream(time).max().getAsInt();
    }

    private int convert(String str) {
        String[] info = str.split(":");
        int hour = Integer.parseInt(info[0]);
        int min = Integer.parseInt(info[1]);
        return hour * 60 + min;
    }
}
