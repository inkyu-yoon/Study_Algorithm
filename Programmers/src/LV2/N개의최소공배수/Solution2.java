package LV2.N개의최소공배수;

class Solution2 {
    public int solution(int[] arr) {

        int prev = arr[0];
        for(int i=1;i<arr.length;i++){
            int result = getLCM(prev,arr[i]);
            prev = result;
        }

        return prev;
    }

    private int getLCM(int num1, int num2){
        int max = num1* num2;
        for(int i=Math.min(num1,num2);i<=max;i++){
            if(i%num1==0 && i%num2==0){
                return i;
            }
        }
        return max;
    }

    private int getGCD(int num1, int num2){
        while(num1!=0){
            int temp = num2;
            num2 = num1%num2;
            num1 = temp;
        }
        return num2;
    }
}
