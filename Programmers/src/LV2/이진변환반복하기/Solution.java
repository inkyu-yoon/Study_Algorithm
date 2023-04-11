package LV2.이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int chance = 0;
        int zero = 0;
        while(!s.equals("1")){
            chance++;
            int one = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    one++;
                }else{
                    zero++;
                }
            }
            s = Integer.toBinaryString(one);
        }
        return new int[]{chance,zero};
    }
}
