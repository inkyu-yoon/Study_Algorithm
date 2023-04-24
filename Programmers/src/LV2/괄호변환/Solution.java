package LV2.괄호변환;

class Solution {
    StringBuilder ans;

    public String solution(String p) {
        ans = new StringBuilder();
        run(p);
        return ans.toString();
    }

    void run(String str){
        if(isRight(str)){
            ans.append(str);
            return;
        }else{
            String[] result = separate(str);
            String u = result[0];
            String v = result[1];
            if(!isRight(u)){
                ans.append("(");
                run(v);
                ans.append(")"+convert(u));
            }else{
                run(u);
                run(v);
            }
        }
    }
    String convert(String str){
        if(str.length()==2){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<str.length()-1;i++){
            if(str.charAt(i)=='('){
                sb.append(')');
            }else{
                sb.append('(');
            }
        }

        return String.format("%s",sb.toString());

    }
    String[] separate(String str){
        char ch = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==ch){
                sb.append(ch);
            }else{
                sb.deleteCharAt(sb.length()-1);
                if(sb.length()==0){
                    return new String[]{str.substring(0,i+1),str.substring(i+1)};
                }
            }
        }
        return new String[]{str,""};
    }

    boolean isRight(String str){

        int i = str.length()/2;

        while(i-->0){
            str = str.replace("()","");
        }
        if(str.length()==0){
            return true;
        }else{
            return false;
        }

    }
}