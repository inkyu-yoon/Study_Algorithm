package 정렬.K번째수;

import java.util.*;

class Solution2 {
    //i번째에서 j번째까지 자르고 정렬한 뒤 k번째 수를 찾는다.
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];

            int[] arr = Arrays.copyOfRange(array,start-1,end);
            Arrays.sort(arr);

            answer[i]=arr[target-1];
        }

        return answer;
    }
}