package 판교가는길.완전탐색.사다리조작;

import java.util.*;
import java.io.*;
public class Main {

    int[][] ladders;
    int R; int C;
    int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    void solution() throws IOException{
        setUp();
        bt(0);

        if(ans==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    void bt(int depth){


        if(depth<ans && run()){

            ans = depth;
            return;
        }

        if(depth==3){
            return;
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C-1;j++){
                if(ladders[i][j]!=0 || ladders[i][j+1]!=0 ){
                    continue;
                }
                ladders[i][j]=1;
                ladders[i][j+1]=-1;
                bt(depth+1);
                ladders[i][j]=0;
                ladders[i][j+1]=0;
            }
        }
    }

    boolean run(){
      for(int i=0;i<C;i++){
          int start = i;
          for(int j=0;j<R;j++){
              if(ladders[j][start]==1){
                  start++;
              }else if(ladders[j][start]==-1){
                  start--;
              }
          }
          if(i!=start){
              return false;
          }
      }
      return true;
    }
    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        R = info[2];
        C = info[0];
        ladders = new int[R][C];
        while(info[1]-->0){
            int [] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            ladders[pos[0]-1][pos[1]-1]=1;
            ladders[pos[0]-1][pos[1]]=-1;
        }

    }
}
