package 덱.AC;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 선영이는 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다.
    // 뒤집기 R 과 버리기 D 가 있다.
    // R은 배열에 있는 수의 순서를 뒤집는 함수 이다.
    // D는 첫번째 수를 버리는 함수 이다. ( 배열이 비어있는 경우 에러가 발생한다.)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 수
        Integer T = Integer.valueOf(br.readLine());
        //각 테스트 결과를 한번에 출력하기 위해 기록할 StringBuilder
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            //역순해서 원소를 제거한다는 개념을, deque의 removedLast로 구현할 것
            //일반적인 제거 명령은 원소의 제일 앞 원소를 제거하는 poll()로 구현
            Deque<Integer> dq = new LinkedList<>();
            String[] commands = br.readLine().split("");

            int size = Integer.valueOf(br.readLine());

            String input = br.readLine();

            int[] arr;
            //만약 입력될 배열의 사이즈가 0인 경우는, [] 빈 배열로 지정하고
            //그 외의 경우에는, [a,b,c,d] 형태로 입력되기 때문에, substring을 사용해서 int [] arr 을 초기화했다.
            if (size == 0) {
                arr = new int[]{};
            } else {
                //for 문으로 구현할 수 있지만, stream 연습 겸.. stream으로 구현 (stream 안쓰고 for문으로 구현해도 상관없다.)
                arr = Arrays.stream(input.substring(1, input.length() - 1).split(",")).mapToInt(s -> Integer.valueOf(s)).toArray();
            }

            // deque에 순서대로 입력(offer) 한다.
            for (int element : arr) {
                dq.offer(element);
            }

            //데이터를 D 하는 과정에서 에러가 발생하였는가? 판단하기 위함
            boolean isError = false;

            // R이 홀수번 나왔다면 역순으로 출력해야한다.
            int R = 0;

            for (int i = 0; i < commands.length; i++) {
                String command = commands[i];

                //R 명령일 때는, R의 갯수만 체크
                if (command.equals("R")) {
                    R++;

                    //D 명령인 경우
                } else {

                    //dq의 사이즈가 0일 때, D 명령이 들어오는 경우 에러를 발생시켜야한다.
                    if (dq.size() == 0) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }

                    //dq 사이즈가 0이 아니라면 R이 짝수개일때는 poll()로 제거, R이 홀수 개일때는 역순이 된 상태이므로 removeLast()로 제거
                    if (R % 2 == 0) {
                        dq.poll();
                    } else {
                        dq.removeLast();
                    }
                }
            }

            // 모든 명령 실행 후에 dq의 사이즈가 0이면서 에러가 발생하지 않았다면 [] 기록
            // D 1 [42] 인 경우가 이에 해당
            if (dq.size() == 0 && !isError) {
                sb.append("[]\n");
                continue;
            }


            // 에러가 발생했던 상황이라면 아래 과정 생략 (이미 sb에 'error' 를 기록했으므로)
            // DD 1 [42] 인 경우가 이에 해당
            if (isError) {
                continue;
            }

            //[a,b,c,d] 꼴로 출력하기 위한 작업
            sb.append("[");

            //역순으로 저장
            if (R % 2 == 1) {
                //역순의 경우 Iterator 클래스의 descendingIterator() 를 사용
                Iterator it = dq.descendingIterator();
                while (it.hasNext()) {
                    sb.append(it.next() + ",");
                }
                sb.deleteCharAt(sb.length() - 1);
            } else {
                Iterator it = dq.iterator();
                while (it.hasNext()) {
                    sb.append(it.next() + ",");
                }
                sb.deleteCharAt(sb.length() - 1);

            }

            sb.append("]\n");
        }
        System.out.println(sb);
    }
}
