package LV2.예상대진표;

class Solution2
{
    public int solution(int n, int a, int b)
    {
        int cnt = 0;

        while(a!=b){
            a = (int)Math.ceil(a/2d);
            b = (int)Math.ceil(b/2d);
            cnt++;
        }


        return cnt;
    }
}
