package 해시.베스트엘범;

import java.util.*;

class Solution {
    // 장르별 플레이 횟수를 알아야 할 것
    // 해당 장르내에서 플레이 횟수 내림차순으로 수록할 것
    public int[] solution(String[] genres, int[] plays) {

        //1. 장르별 총 재생수를 map을 이용해서 구함
        Map<String, Integer> playsPerGenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            playsPerGenres.put(genres[i], playsPerGenres.getOrDefault(genres[i], 0) + plays[i]);
        }

        //2. 장르별 총 재생수를 계산한 playsPerGenres를 사용해서 재생횟수를 기준으로 정렬한다.
        List<String> orderByPlays = new ArrayList<>();
        for (String genresName : playsPerGenres.keySet()) {
            orderByPlays.add(genresName);
        }
        Collections.sort(orderByPlays, (a, b) -> playsPerGenres.get(b) - playsPerGenres.get(a));

        //장르별로 정렬을 했으니, 최대 2개씩 노래 번호를 골라 album에 넣는다.
        List<Integer> album = new ArrayList<>();

        //3. 장르별 재생수 기준, 1번째 인덱스와 2번째 인덱스를 찾아야 한다.
        for (String genresName : orderByPlays) {

            //3.1 재생수가 가장 많은 번호를 찾는다.
            int firstIndex = -1;
            for (int i = 0; i < genres.length; i++) {
                // 해당 장르를 찾은 경우
                if (genresName.equals(genres[i])) {
                    //할당되기 전
                    if (firstIndex == -1) {
                        firstIndex = i;
                    } else {
                        if (plays[firstIndex] < plays[i]) {
                            firstIndex = i;
                        }
                    }
                }
            }

            //3.2 재생수가 두번째로 많은 번호를 찾는다.
            int secondIndex = -1;
            for (int i = 0; i < genres.length; i++) {
                if (genresName.equals(genres[i]) && firstIndex != i) {
                    if (secondIndex == -1) {
                        secondIndex = i;
                    } else {
                        if (plays[secondIndex] < plays[i]) {
                            secondIndex = i;
                        }
                    }
                }
            }

            album.add(firstIndex);

            //2번째 곡을 찾은 경우만 추가
            if (secondIndex != -1) {
                album.add(secondIndex);
            }
        }

        // 배열로 변환 후 반환한다.
        int[] answer = new int[album.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = album.get(i);
        }
        return answer;
    }
}