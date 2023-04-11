package LV2.점프와순간이동;

// 건전지 사용량을 가장 적게
// 현재까지 온거리 * 2 에 해당하는 위치로 순간이동 가능
// 점프하면 건전지 사용
public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n!=0){
            if(n%2==0){
                n=n/2;
            }else{
                n--;
                ans++;
            }
        }
        return ans;
    }
}