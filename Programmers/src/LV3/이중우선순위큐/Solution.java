package LV3.이중우선순위큐;

import java.util.*;
class Solution {
    PriorityQueue<Integer> pqAsc;
    PriorityQueue<Integer> pqDesc;
    public int[] solution(String[] operations) {
        pqAsc = new PriorityQueue<>();
        pqDesc = new PriorityQueue<>();

        for(String op : operations){
            String[] info = op.split(" ");
            String command = info[0];
            int num = Integer.parseInt(info[1]);

            if(command.equals("I")){
                pqAsc.offer(num);
                pqDesc.offer(-1*num);
            }else{
                if(num==1 && !isEmpty()){
                    int max = pqDesc.poll()*-1;
                    pqAsc.remove(max);
                }else if(num ==-1 && !isEmpty()){
                    int min = pqAsc.poll()*-1;
                    pqDesc.remove(min);
                }
            }
        }

        if(isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{-1*pqDesc.poll(),pqAsc.poll()};
        }

    }
    boolean isEmpty(){
        return pqAsc.isEmpty() && pqDesc.isEmpty();
    }
}