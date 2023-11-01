package LV2.방문길이;

import java.util.*;

class Solution2 {
    Set<String> set = new HashSet<>();

    public int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0;
        for (String dir : dirs.split("")) {
            int nx = x, ny = y;
            if (dir.equals("U")) {
                if (x != 5) {
                    nx = x + 1;
                }
            } else if (dir.equals("D")) {
                if (x != -5) {
                    nx = x - 1;
                }
            } else if (dir.equals("R")) {
                if (y != 5) {
                    ny = y + 1;
                }
            } else if (dir.equals("L")) {
                if (y != -5) {
                    ny = y - 1;
                }
            }
            if (x == nx && y == ny) {
                continue;
            }
            set.add(String.format("%d%d%d%d", x, y, nx, ny));
            set.add(String.format("%d%d%d%d", nx, ny, x, y));
            x = nx;
            y = ny;
        }
        return set.size() / 2;
    }
}