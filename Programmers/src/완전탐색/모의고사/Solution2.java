package 완전탐색.모의고사;

import java.util.*;

class Solution2 {
    public int[] solution(int[] answers) {

        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};

        int firstScore =0;
        int secondScore=0;
        int thirdScore=0;

        for(int i=0;i<answers.length;i++){
            if(answers[i]==first[i%first.length]){
                firstScore++;
            }
            if(answers[i]==second[i%second.length]){
                secondScore++;
            }
            if(answers[i]==third[i%third.length]){
                thirdScore++;
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int max = Math.max(Math.max(firstScore,secondScore),thirdScore);

        if(max==firstScore){
            q.offer(1);
        }
        if(max==secondScore){
            q.offer(2);
        }
        if(max==thirdScore){
            q.offer(3);
        }

        int[] answer = new int[q.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = q.poll();
        }

        return answer;
    }
}