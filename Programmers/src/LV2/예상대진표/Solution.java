package LV2.예상대진표;

// 1 2 3 4 5 6 7 8
//  1   4   5   7
//    4       7   3라운드에서 만남
import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a!=b){
            a=(int)Math.ceil(a/2d);
            b=(int)Math.ceil(b/2d);
            answer++;
        }

        return answer;
    }
}
