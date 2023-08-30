package 바킹독.해시.싸이버개강총회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 개강 총회를 시작하기 전에 입장 확인 여부를 확인한다.
// 개강 총회를 시작한 시간 이하에 대화를 하면 체크
// 체크했던 사람들 중, 개강총회 끝 ~ 스트리밍 끝 안에 댓글 남기면 체크

public class Main {
    int startTime;
    int endTime;
    int endStreamingTime;
    Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        startTime = convertStringToTime(input[0]);
        endTime = convertStringToTime(input[1]);
        endStreamingTime = convertStringToTime(input[2]);
        int cnt = 0;
        while (true) {
            String log = br.readLine();

            if (log == null || log.equals("")) {
                break;
            }

            input = log.split(" ");
            int time = convertStringToTime(input[0]);
            String id = input[1];
            if (time <= startTime) {
                set.add(id);
            } else if (endTime <= time && time <= endStreamingTime) {
                if (set.contains(id)) {
                    set.remove(id);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }


    private int convertStringToTime(String str) {
        String[] split = str.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);

    }
}
