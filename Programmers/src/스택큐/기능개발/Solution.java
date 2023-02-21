package 스택큐.기능개발;

import java.util.*;

class Solution {
    // 각 배포마다 몇개의 기능이 배포되는지를 찾아라 (100% 이상일때 배포)
    // 앞에 있는 기능이 배포되어야 한다.
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        // 남은 일수를 계산해서 큐에 다 넣음
        for(int i=0;i<progresses.length;i++){
            int leftDay = (int)Math.ceil((100-progresses[i])/(double)speeds[i]);
            q.offer(leftDay);
        }

        // 남은 일수가 [7 3 9] 라고 할때, 제일 첫번째 인덱스부터 시작해서
        // 더 큰 수가 나올때까지 count 증가, 더 큰 수가 나오면 count 를 list에 저장
        int max = Integer.MIN_VALUE;
        int count =1 ;
        while(!q.isEmpty()){
            if(max<q.peek()){
                list.add(count);
                count = 1;
                max=q.poll();
            }else{
                count++;
                q.poll();
            }
        }

        // 마지막 데이터는 while 문 밖에서 추가해주기
        list.add(count);

        // 배열로 옮기기
        int[] answer = new int[list.size()-1];
        for(int i=1;i<list.size();i++){
            answer[i-1]=list.get(i);
        }

        return answer;
    }
}