package LV2.일이사나라의숫자;

class Solution {
    public String solution(int n) {
        return convert(n).replaceAll("3","4");
    }

    String convert(int n){
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            if(n%3==0){
                sb.append("3");
                n=n/3-1;
            }else{
                sb.append(n%3);
                n/=3;
            }
        }
        return sb.reverse().toString();
    }
}