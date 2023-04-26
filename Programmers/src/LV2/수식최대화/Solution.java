package LV2.수식최대화;

import java.util.*;
import java.util.regex.*;

class Solution {
    Deque<String> q;
    public long solution(String expression) {

        long answer = 0;
        q = new ArrayDeque<>();
        String[] pri = {"*+-","+*-","*-+","+-*","-*+","-+*"};

        for(int i=0;i<pri.length;i++){

            boolean flag = true;
            String[] ops = pri[i].split("");
            String ex = expression;

            for(int j=0;j<ops.length;j++){

                String op = ops[j];
                Pattern p;
                Matcher m;

                if(flag){
                    p = Pattern.compile("\\d+|\\S");
                    m = p.matcher(ex);
                }else{
                    p = Pattern.compile("-?\\d+|\\S");
                    m = p.matcher(ex);
                }

                if(op.equals("-")){
                    flag = false;
                }

                while(m.find()){
                    String s = m.group();
                    if(s.equals(op)){
                        m.find();
                        q.offer(String.valueOf(getValue(q.pollLast(),m.group(),op)));
                    }else{
                        q.offer(s);
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
        for(String str : q){
            sb.append(str);
        }
        q.clear();
        return sb.toString();
    }

}