package 판교가는길.완전탐색.연산자끼워넣기;

//만들 수 있는 최댓값과 최솟값을 구한다.


import java.util.*;
import java.io.*;
public class Main {
    Stack<Integer> s;
    int total;
    int[] arr;
    int[] ops;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        // + - * /
        ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        total = Arrays.stream(ops).sum();
        s = new Stack<>();

        bt();
        System.out.println(max);
        System.out.println(min);
    }

    void bt(){
        if (s.size() == total) {
            calculate();
            return;
        }
        for(int i=0;i<4;i++){
            if(ops[i]==0){
                continue;
            }
            s.push(i);
            ops[i]-=1;
            bt();
            s.pop();
            ops[i]+=1;
        }
    }
    void calculate(){
        int result =arr[0];
        for(int i=0;i<s.size();i++){
            if(s.get(i)==0){
                result +=arr[i+1];
            }else if(s.get(i)==1){
                result -=arr[i+1];
            }else if(s.get(i)==2){
                result *= arr[i+1];
            }else if(s.get(i)==3){
                result /=arr[i+1];
            }
        }
        max = Math.max(max,result);
        min = Math.min(min,result);
    }
}
