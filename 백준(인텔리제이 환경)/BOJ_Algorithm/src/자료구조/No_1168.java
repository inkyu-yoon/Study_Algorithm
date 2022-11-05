package 자료구조;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1168 {
    static StringBuilder sb = new StringBuilder();
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.valueOf(input[0]);
        int k = Integer.valueOf(input[1]);

        tree = new int[4000040];
        init(1, n, 1);

        int index = 1;

        sb.append("<");
        for (int i = 0; i < n; i++) {

            int size = n - i;
            index += k-1;
            if (index % size == 0) {
                index = size;
            } else if (index > size) {
                index %= size;
            }

            int num = query(1, n, 1, index);
            update(1, n, 1, num);

            if (i == n - 1) {
                sb.append(num + ">");
            } else {
                sb.append(num + ", ");
            }
        }
        System.out.println(sb);
    }


    public static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = 1;
        }

            int midPoint = (start + end) / 2;

            return tree[node] = init(start, midPoint, node * 2) + init(midPoint + 1, end, node * 2 + 1);

    }

    public static int query(int start, int end, int node, int val) {
        if (start == end) {
            return start;
        }
        int midPoint = (start + end) / 2;
        if (val <= tree[2 * node]) {
            return query(start, midPoint, 2 * node, val);
        } else {
            return query(midPoint + 1, end, 2 * node + 1, val - tree[2 * node]);
        }
    }

    public static long update(int start, int end, int node, int a) {
        if (start == end) {
            return tree[node] = 0;
        }
        tree[node]--;

        int midPoint = (start + end) / 2;
        if (a > midPoint) {
            return update(midPoint + 1, end, 2 * node + 1, a);
        } else {
            return update(start,midPoint, 2 * node , a);

        }

    }
}