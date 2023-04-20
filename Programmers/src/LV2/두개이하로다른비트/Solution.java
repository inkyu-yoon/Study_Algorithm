package LV2.두개이하로다른비트;

class Solution {
    public long[] solution(long[] numbers) {
        int size = numbers.length;
        long[] answer = new long[size];


        for(int i=0;i<size;i++){
            long num = numbers[i];
            if(num==0){
                answer[i]=1;
                continue;
            }
            String bin = Long.toBinaryString(num);
            int idx = bin.lastIndexOf("0");

            String result;
            if(idx>0){
                if(idx==bin.length()-1){
                    result = bin.substring(0,idx)+"1";
                }else{
                    result = bin.substring(0,idx)+"10"+bin.substring(idx+2);
                }
            }else{
                result = "10"+"1".repeat(bin.length()-1);
            }
            answer[i]=Long.parseLong(result,2);
        }
        return answer;
    }
}

// 101 -> 110
// 1010 -> 1011
// 10111 -> 11011
