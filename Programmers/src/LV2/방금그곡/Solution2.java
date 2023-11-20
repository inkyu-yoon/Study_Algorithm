package LV2.방금그곡;

import java.util.*;

class Solution2 {
    List<Music> list = new ArrayList<>();

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = convert(m);
        for (int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            int time = getTime(infos[0], infos[1]);
            list.add(new Music(time, i, infos[2], convert(infos[3])));
        }

        List<Music> candidates = new ArrayList<>();
        for (Music music : list) {
            if (check(music, m)) {
                candidates.add(music);
            }
        }

        Collections.sort(candidates, (a, b) -> {
            int result = b.time - a.time;
            if (result == 0) {
                return a.idx - b.idx;
            }
            return result;
        });

        return candidates.isEmpty() ? "(None)" : candidates.get(0).name;
    }

    private String convert(String melody) {
        melody = melody.replaceAll("C#", "H");
        melody = melody.replaceAll("D#", "I");
        melody = melody.replaceAll("F#", "J");
        melody = melody.replaceAll("G#", "K");
        melody = melody.replaceAll("A#", "L");
        return melody;
    }

    private int getTime(String start, String end) {
        String[] starts = start.split(":");
        String[] ends = end.split(":");
        int s = (Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]));
        int e = (Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]));
        return e - s;
    }

    private boolean check(Music music, String m) {
        String melody;
        if (music.time < music.melody.length()) {
            melody = music.melody.substring(0, music.time);
        } else {
            melody = music.melody.repeat(music.time / music.melody.length() + 1);

        }
        return melody.indexOf(m) != -1;
    }


    static class Music {
        int time;
        int idx;
        String name;
        String melody;

        public Music(int time, int idx, String name, String melody) {
            this.time = time;
            this.idx = idx;
            this.name = name;
            this.melody = melody;
        }
    }
}
