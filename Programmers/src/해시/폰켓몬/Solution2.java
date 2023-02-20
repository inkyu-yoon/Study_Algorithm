package 해시.폰켓몬;
import java.util.*;

class Solution2 {
    // 연구실에 있는 N마리의 폰켓몬 중 N/2마리를 가져감
    // N마리 중 가장 많은 가짓수로 가져가야한다. -> 가짓수를 답으로 출력하는 함수 작성
    // N은 1이상 10000이하의 자연수이며 항상 짝수이다.
    // 폰켓몬 종류 번호는 1이상 200000이하의 자연수이다.
    public int solution(int[] nums) {
        int answer = 0;

        int totalNum = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        //가짓수 구하기 맵에 넣으면 자동으로 중복 제거됨.
        for(int num : nums){
            map.put(num,1);
        }

        int maxNum = map.size();

        // 만약 폰켓몬의 종류 수가 N/2보다 크면, N/2개 보다 많이 고를 수 없으므로 N/2
        if((totalNum/2)<=maxNum){
            answer = totalNum/2;
        }else{
            answer = maxNum;
        }

        return answer;
    }
}