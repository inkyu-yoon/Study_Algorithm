package 구름톤첼린지.문자열나누기;

import java.io.*;
import java.util.*;
class Main {
    int N;
    String S;
    Set<String> set = new HashSet<>();

    Stack<Integer> s = new Stack<>();
    List<String[]> cases = new ArrayList<>();
    int sum = 0;
    int ans = 0;
    Map<String,Integer> map = new HashMap();
    public static void main(String[] args) throws Exception {
        new Main().sol();
    }

    public void sol() throws Exception{
        setUp();
        getCases();
        convertSetToMap();
        getAns();
        System.out.println(ans);
    }

    private void getAns() {
        for (String[] arr : cases) {
            int score = 0;

            for (String str : arr) {
                score += map.get(str);
            }

            ans = Math.max(ans, score);
        }
    }


    public void convertSetToMap(){
        List<String> list = new ArrayList<>();

        for(String s : set){
            list.add(s);
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            map.put(list.get(i),i+1);
        }
    }
    //3 수를 더했을 때, N이 나오는 경우의 수
    public void getCases(){
        if(s.size()==3){
            if(sum==N){
                int idx =0;
                String[] strArr = new String[3];

                for (int i = 0; i < 3; i++) {
                    int n = s.get(i);
                    String str = S.substring(idx, idx + n);
                    strArr[i] = str;
                    set.add(str);
                    idx+=n;
                }

                cases.add(strArr);
            }
            return;
        }

        for(int i=1;i<=N-2;i++){
            s.push(i);
            sum+=i;
            getCases();
            s.pop();
            sum-=i;
        }
    }

    public void setUp() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = br.readLine();

    }
}