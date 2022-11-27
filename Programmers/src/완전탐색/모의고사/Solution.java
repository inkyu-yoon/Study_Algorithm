package 완전탐색.모의고사;
import java.util.*;

class Solution {
    //1번 수포자 방식 1 2 3 4 5
    //2번 수포자 방식 2 1 2 3 2 4 2 5
    //3번 수포자 방식 3 3 1 1 2 2 4 4 5 5
    //가장 많이 맞힌 사람을 리턴하고, 여럿일 경우 오름차순 정렬
    public int[] solution(int[] answers) {

        List<Integer> list = new ArrayList<>();
        int[] student1 = {1,2,3,4,5};
        int score1 =0;
        int[] student2 = {2,1,2,3,2,4,2,5};
        int score2 =0;
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int score3 =0;


        //정답 체크
        for(int i=0;i<answers.length;i++){
            if(student1[i%student1.length]==answers[i]){
                score1++;
            }
            if(student2[i%student2.length]==answers[i]){
                score2++;
            }
            if(student3[i%student3.length]==answers[i]){
                score3++;
            }
        }

        //점수 최댓값
        int max = Math.max(Math.max(score1,score2),score3);

        //아래 로직대로 list를 채우면, 오름차순 정렬이 된다.
        if(max == score1){
            list.add(1);
        }
        if(max==score2){
            list.add(2);
        }
        if(max==score3){
            list.add(3);
        }

        //채워진 list의 크기와 같은 배열을 생성하고, 채운다.
        int [] answer = new int[list.size()];

        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }

        return answer;
    }
}