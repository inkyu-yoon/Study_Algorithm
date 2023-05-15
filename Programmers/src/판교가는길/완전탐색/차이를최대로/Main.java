package 판교가는길.완전탐색.차이를최대로;

import java.util.*;
import java.io.*;
public class Main {
    int N;
    int[] arr;
    int ans =0;
    Stack<Integer> s;
    public static void main(String[] args) throws Exception{
        new Main().solution();

    }
    void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        s = new Stack<>();
        bt();
        System.out.println(ans);
    }
    void bt(){
        if(s.size()==N){
            ans=Math.max(ans,getAns());
            return;
        }

        for(int i=0;i<N;i++){
            if(s.contains(i)){
                continue;
            }
            s.push(i);
            bt();
            s.pop();
        }
    }
    int getAns(){
        int result = 0;
       for(int i=0;i<s.size()-1;i++){
           result+=Math.abs(arr[s.get(i)]-arr[s.get(i+1)]);
       }
       return result;
    }
}

/**
 6
 20 1 15 8 4 10
 */