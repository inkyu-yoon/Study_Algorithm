package 바킹독.해시.나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int N = input[0], M = input[1];
        HashMap<String, String> keyByName = new HashMap<>();
        HashMap<String, String> keyByNum = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            keyByName.put(name, String.valueOf(i));
            keyByNum.put(String.valueOf(i), name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            if (keyByName.containsKey(problem)) {
                sb.append(keyByName.get(problem) + "\n");
            } else {
                sb.append(keyByNum.get(problem) + "\n");
            }
        }
        System.out.println(sb);
    }


}
