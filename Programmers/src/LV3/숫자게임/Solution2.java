package LV3.숫자게임;

import java.util.*;
class Solution2 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        List<Integer> listA = convert(A);
        List<Integer> listB = convert(B);
        int N = listB.size();

        for(int i=0;i<N;i++){
            int num = listB.get(i);

            for(int j=0;j<listA.size();j++){
                if(listA.get(j)<num){
                    listA.remove(j);
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }


    public List<Integer> convert(int[] arr){
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for(int n : arr){
            list.add(n);
        }
        return list;
    }

}
