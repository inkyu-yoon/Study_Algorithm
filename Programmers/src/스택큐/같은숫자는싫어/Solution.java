package 스택큐.같은숫자는싫어;

import java.util.*;

// 연속적으로 나타나는 숫자를 지운다.

public class Solution {
    public int[] solution(int []arr) {

        int target = arr[0];

        List<Integer> ans = new ArrayList<>();
        ans.add(target);

        // 다른 숫자가 나올때마다 list에 추가해준다.
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=target){
                target=arr[i];
                ans.add(target);
            }
        }

        int[] answer = new int[ans.size()];

        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }

        return answer;
    }
}