package LV2.연속부분수열합의개수;
import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] elements) {

        int [] arr = IntStream.concat(Arrays.stream(elements),Arrays.stream(elements))
                .toArray();

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<elements.length;i++){
            for(int j=0;j<elements.length;j++){
                int result = 0;
                for(int k = i;k<=i+j;k++){
                    result +=arr[k];
                }
                set.add(result);
            }
        }

        return set.size();
    }
}