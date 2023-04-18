package LV2.n진수게임;

// 진법 n
class Solution {
    String[] unit = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public String solution(int n, int t, int m, int p) {

        String result = "";
        int i = 0;
        while(result.length()<=t*m){
            result+=convert(i++,n);
        }

        String answer = "";
        int idx=p-1;

        do{
            answer+=result.charAt(idx);
            idx+=m;
        }while(answer.length()!=t);

        return answer;
    }

    String convert(int num, int n){
        StringBuilder sb = new StringBuilder();
        if(num==0){
            return "0";
        }
        while(num!=0){
            sb.append(unit[num%n]);
            num/=n;
        }
        return sb.reverse().toString();
    }
}