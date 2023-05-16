package 판교가는길.완전탐색.좋은수열;

//  1,2,3 으로만 이루어져 있는 길이가 N인 좋은 수열들 중 가장 작은 수를 나타내는 수열을 출력

/**
 7

 1213121
 */
import java.util.*;
public class Main {
    StringBuilder sb;
    int N;
    String ans;
    public static void main(String[] args) {
        new Main().solution();
    }
    void solution(){
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        bt();
    }
    void bt(){
        if(sb.length()==N){
            System.out.println(sb);
            System.exit(0);
            return;
        }

        for(int i=1;i<=3;i++){
            if(isBad(i)){
                continue;
            }
            sb.append(i);
            bt();
            sb.deleteCharAt(sb.length()-1);
        }

    }
    boolean isBad(int num){
        String result = String.format("%s%d",sb.toString(),num);
        for(int i=1;i<=result.length()/2;i++){
            String back = result.substring(result.length()-i);
            String front = result.substring(result.length()-2*i,result.length()-i);
            if(back.equals(front)){
                return true;
            }
        }
        return false;
    }
}
