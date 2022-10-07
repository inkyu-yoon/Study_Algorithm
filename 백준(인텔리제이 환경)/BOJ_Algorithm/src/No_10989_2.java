import java.io.*;

public class No_10989_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] array = new int[10001];

        for (int i = 1; i <= N; i++) {
            array[Integer.valueOf(br.readLine())]++;
        }
        for (int i = 0; i < array.length; i++) {
            bw.write((i + "\n").repeat(array[i]));
        }
        bw.flush();
        bw.close();

    }
}
