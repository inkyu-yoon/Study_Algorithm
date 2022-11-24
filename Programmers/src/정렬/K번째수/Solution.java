package 정렬.K번째수;

import java.util.*;

class Solution {
    //i번째에서 j번째까지 자르고 정렬한 뒤 k번째 수를 찾는다.
    public int[] solution(int[] array, int[][] commands) {
        //케이스 갯수 만큼 정답 배열을 생성
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            //정렬에 사용할 리스트 루프마다 초기화
            List<Integer> list = new ArrayList<>();

            // substring 해서 list에 추가
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                list.add(array[j]);
            }

            // 리스트 정렬
            Collections.sort(list);

            //k번째 수 배열에 저장
            answer[i] = list.get(commands[i][2] - 1);

        }

        return answer;
    }
}