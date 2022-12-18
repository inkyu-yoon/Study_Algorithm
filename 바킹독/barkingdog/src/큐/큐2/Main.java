package 큐.큐2;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.valueOf(br.readLine());
        Deque<Integer> queue = new LinkedList<>();

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                queue.offer(Integer.valueOf(input[1]));
            } else if (input[0].equals("pop")) {
                if(queue.isEmpty()){
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(queue.poll()+"\n");
            }else if (input[0].equals("size")) {
                sb.append(queue.size()+"\n");
            }else if (input[0].equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1+"\n");
                } else {
                    sb.append(0+"\n");

                }
            }else if (input[0].equals("front")) {
                if(queue.isEmpty()){
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(queue.peek()+"\n");
            }else if (input[0].equals("back")) {
                if(queue.isEmpty()){
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(queue.getLast()+"\n");
            }
        }
        System.out.println(sb);

    }
}
