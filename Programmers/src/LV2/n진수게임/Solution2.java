package LV2.n진수게임;

class Solution2 {
    String[] arr = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public String solution(int n, int t, int m, int p) {
        String result = "";
        int num = 0;
        while(result.length()<m*t){
            String converted = convertDigit(num++,n);
            result+=converted;
        }
        StringBuilder sb = new StringBuilder();
        String[] splited = result.split("");
        for(int i=p-1;i<result.length();i+=m){
            sb.append(splited[i]);
            if(sb.length()==t){
                break;
            }
        }


        return sb.toString();
    }

    private String convertDigit(int num,int digit){
        if(num==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            String s = arr[num%digit];
            num/=digit;
            sb.append(s);
        }
        return sb.reverse().toString();
    }
}