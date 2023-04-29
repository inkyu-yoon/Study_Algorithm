package LV2.줄서는방법;

import java.util.*;
class Solution {
    long[] fact;
    List<Integer> list;
    int[] ans;
    public int[] solution(int n, long k) {
        getFact(n);

        k--;

        for(int i=0;i<n;i++){
            int idx = (int)(k/fact[n-i-1]);
            ans[i]=list.get(idx);
            list.remove(idx);
            k%=fact[n-i-1];
        }

        return ans;
    }
    void getFact(int n){
        list = new ArrayList<>();
        fact = new long[n];
        ans = new int[n];
        fact[0]=1;
        for(int i=1;i<n;i++){
            fact[i]=i*fact[i-1];
            list.add(i);
        }
        list.add(n);
    }
}