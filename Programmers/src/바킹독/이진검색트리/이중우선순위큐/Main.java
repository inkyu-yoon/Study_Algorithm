package 바킹독.이진검색트리.이중우선순위큐;


import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (T-- > 0) {

            treeMap.clear();
            k = Integer.parseInt(br.readLine());
            while (k-- > 0) {
                String[] input = br.readLine().split(" ");
                String cmd = input[0];
                int num = Integer.parseInt(input[1]);
                if (cmd.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else {
                    if (!treeMap.isEmpty()) {
                        if (num == 1) {
                            Integer max = treeMap.lastKey();
                            if (treeMap.get(max) == 1) {
                                treeMap.remove(max);
                            } else {
                                treeMap.put(max, treeMap.get(max) - 1);
                            }
                        } else {
                            Integer min = treeMap.firstKey();
                            if (treeMap.get(min) == 1) {
                                treeMap.remove(min);
                            } else {
                                treeMap.put(min, treeMap.get(min) - 1);
                            }
                        }
                    }
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(String.format("%d %d\n", treeMap.lastKey(), treeMap.firstKey()));
            }


        }

        System.out.println(sb);

    }
}
