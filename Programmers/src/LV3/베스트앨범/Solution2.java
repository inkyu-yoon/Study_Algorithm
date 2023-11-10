package LV3.베스트앨범;

import java.util.*;
// 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범 출시
// 1. 가장 많이 재생된 장르를 먼저 수록
// 2. 장르 내에서는 많이 재생된 노래를 먼저 수록 (2곡 까지, 1곡이라면 1곡만)
// 3. 재생 횟수가 같으면 고유 번호가 낮은 노래를 먼저 수록

class Solution2 {
    Map<String, Integer> genreRank = new HashMap<>();
    List<Music> musics = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        calculateGenreRank(genres, plays);

        for (int i = 0; i < plays.length; i++) {
            String genre = genres[i];
            musics.add(new Music(genreRank.get(genre), i, plays[i]));
        }

        Collections.sort(musics, (a, b) -> {
            int result = a.genreRank - b.genreRank;
            if (result == 0) {
                int result2 = b.plays - a.plays;
                if (result2 == 0) {
                    return a.idx - b.idx;
                } else {
                    return result2;
                }
            } else {
                return result;
            }
        });
        int[] cnts = new int[genreRank.size()];
        Arrays.fill(cnts, 2);
        for (Music m : musics) {
            if (cnts[m.genreRank] != 0) {
                answer.add(m.idx);
                cnts[m.genreRank]--;
            }
        }


        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void calculateGenreRank(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Genre> list = new ArrayList<>();
        for (String genre : map.keySet()) {
            int n = map.get(genre);
            list.add(new Genre(genre, n));
        }

        Collections.sort(list, (a, b) -> b.plays - a.plays);
        for (int i = 0; i < list.size(); i++) {
            Genre g = list.get(i);
            genreRank.put(g.name, i);
        }

    }

    static class Genre {
        String name;
        int plays;

        public Genre(String name, int plays) {
            this.name = name;
            this.plays = plays;
        }
    }

    static class Music {
        int genreRank;
        int idx;
        int plays;

        public Music(int genreRank, int idx, int plays) {
            this.genreRank = genreRank;
            this.idx = idx;
            this.plays = plays;
        }
    }
}