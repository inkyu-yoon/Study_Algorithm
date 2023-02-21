package 스택큐.프린터;

import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 큐(printer)에는 [중요도, 초기위치] 가 담긴 배열을 넣어줄 것
        // 우선순위 큐(rank)에는 프린터의 중요도를 내림차순으로 넣어줄 것
        Queue<int[]> printer = new LinkedList<>();
        PriorityQueue<Integer> rank = new PriorityQueue<>(Collections.reverseOrder());

        // 프린터 정보를 큐와 우선순위 큐에 넣어준다.
        for(int i=0;i<priorities.length;i++){
            rank.offer(priorities[i]);
            printer.offer(new int[] {priorities[i],i});
        }

        // count는 location에 해당하는 문서까지 얼마나 걸릴지 기록
        int count =1;

        while(true){
            //프린터 순서대로 문서 중요도를 파악한다.
            int[] element = printer.poll();

            // 우선순위 큐는 내림차순으로 정렬되어있고, 우선순위 큐 peek() 했을때
            // 인쇄물의 우선순위와 같아야 인쇄가 가능하다.
            if(element[0]==rank.peek()){

                // 만약 해당 문서의 순서가, 우리가 알기를 원했던 위치의 문서라면? answer에 기록한다.
                if(element[1]==location){
                    answer = count;
                    break;
                }

                // 인쇄되었다면, 우선순위 큐에서도 poll() 처리하고, count 를 1 증가시킨다.
                rank.poll();
                count++;

                //우선순위 큐에 남아있는 순위보다 낮으면, 다시 큐에 offer한다.
            }else{
                printer.offer(element);
            }
        }

        return answer;
    }
}