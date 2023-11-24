package LV2.수식최대화;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    Stack<String> stack;
    public long solution(String expression) {

        long answer = 0;
        stack = new Stack<>();
        String[] pri = {"*+-","+*-","*-+","+-*","-*+","-+*"};

        for(String ops : pri){
            boolean beforeMinus = true;
            String ex = expression;
            for(String op : ops.split("")){
                Pattern p;
                Matcher m;

                if(beforeMinus){
                    p = Pattern.compile("\\d+|\\S");
                    m = p.matcher(ex);
                }else{
                    p = Pattern.compile("-?\\d+|\\S");
                    m = p.matcher(ex);
                }


                if(op.equals("-")){
                    beforeMinus = false;
                }

                while(m.find()){
                    String s = m.group();
                    if(s.equals(op)){
                        m.find();
                        stack.push(String.valueOf(getValue(stack.pop(),m.group(),op)));
                    }else{
                        stack.push(s);
                    }
                }
                ex = toEx();
            }
            answer = Math.max(answer,Math.abs(Long.parseLong(ex)));
        }
        return answer;
    }

    long getValue(String num1,String num2,String op){
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
        if(op.equals("*")){
            return n1*n2;
        }else if(op.equals("+")){
            return n1+n2;
        }else{
            return n1-n2;
        }
    }

    String toEx(){
        StringBuilder sb = new StringBuilder();
        for(String str : stack){
            sb.append(str);
        }
        stack.clear();
        return sb.toString();
    }

}