package 바킹독.시뮬레이션.톱니바퀴;

import java.io.*;
import java.util.*;

public class Main {
    static List<Deque<Integer>> gears;
    static boolean[] checked;
    static boolean[] checkMag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            gears.add(new LinkedList<>());
            Deque<Integer> dq = gears.get(i);
            String[] input = br.readLine().split("");
            for (int j = 0; j < input.length; j++) {
                dq.add(Integer.parseInt(input[j]));
            }
        }
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int gearIdx = input[0]-1, dir = input[1];
            checked = new boolean[4];
            checkMag = new boolean[3];

            for (int i = 0; i < 3; i++) {
                checkMag[i] = check(i, i + 1);
            }
            rotate(gearIdx, dir);
        }

        System.out.println(getScore());

    }

    private static int getScore() {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += gears.get(i).getFirst() * Math.pow(2, i);
        }
        return result;
    }

    private static void rotate(int gearIdx, int dir) {
        if (checked[gearIdx]) {
            return;
        }

        Deque<Integer> gear = gears.get(gearIdx);
        if (dir == 1) {
            int tmp = gear.pollLast();
            gear.offerFirst(tmp);
        } else {
            int tmp = gear.pollFirst();
            gear.offerLast(tmp);
        }

        checked[gearIdx] = true;

        if (0 < gearIdx && gearIdx < 3) {
            if(checkMag[gearIdx]) rotate(gearIdx + 1, dir * -1);
            if(checkMag[gearIdx-1]) rotate(gearIdx - 1, dir * -1);
        } else if (gearIdx == 0) {
            if(checkMag[gearIdx]) rotate(gearIdx + 1, dir * -1);
        } else {
            if(checkMag[gearIdx-1]) rotate(gearIdx - 1, dir * -1);
        }
    }

    private static boolean check(int first, int second) {
        int num1 = getInfo(first,3);
        int num2 = getInfo(second,7);

        return num1 != num2;
    }

    private static int getInfo(int first, int num) {
        Deque<Integer> gear = gears.get(first);
        Iterator<Integer> iterator = gear.iterator();
        int target = 0;
        for (int i = 0; i < num; i++) {
            target = iterator.next();
        }
        return target;
    }

}
