import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10814_2{
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringBuilder[] stringBuilderArray = new StringBuilder[201];
        for (int i = 0; i < 201; i++){
            stringBuilderArray[i] = new StringBuilder();
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            stringBuilderArray[Integer.valueOf(input[0])].append(Integer.valueOf(input[0])+" "+input[1]).append("\n");

        }

        for (StringBuilder k : stringBuilderArray){
            sb.append(k);
        }

        System.out.println(sb);

    }

}