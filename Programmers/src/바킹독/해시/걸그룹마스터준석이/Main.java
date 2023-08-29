package 바킹독.해시.걸그룹마스터준석이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int N = input[0], M = input[1];
        HashMap<String, String> keyWithMember = new HashMap<>();
        HashMap<String, String[]> keyWithTeam = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String team = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String[] members = new String[num];
            for (int j = 0; j < num; j++) {
                String name = br.readLine();
                keyWithMember.put(name, team);
                members[j] = name;
            }
            Arrays.sort(members);
            keyWithTeam.put(team, members);
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                String[] members = keyWithTeam.get(quiz);
                for (String member : members) {
                    sb.append(member + "\n");
                }
            } else {
                sb.append(keyWithMember.get(quiz) + "\n");
            }
        }
        System.out.println(sb);

    }
}
