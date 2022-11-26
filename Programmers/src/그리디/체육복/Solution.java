package 그리디.체육복;

import java.util.Arrays;

class Solution {
    //바로 앞번호 혹은 뒷번호 학생에게만 체육복을 빌려줄 수 있다.
    //체육수업을 최대한 많이 들을 수 있도록 해야한다.
    //여벌 체육복을 가져온 사람이 도난 당하는 경우도 있음
    public int solution(int n, int[] lost, int[] reserve) {
        //확실하게 체육 수업 들을 수 있는 학생 수
        int answer = 0;

        //체육복 갖고 있는지 (true 일 경우 갖고 있는 것)
        boolean[] cloth = new boolean[n + 2];
        //빌려줄 수 있는 학생 번호 체크
        boolean[] getReserve = new boolean[n + 2];

        //옷을 다 갖고 있다고 가정
        Arrays.fill(cloth, true);

        // 잃어버린 사람 체크 ( 여유복 있는 사람도 잃어버린 사람에 포함됨)
        for (int no : lost) {
            cloth[no] = false;
        }

        // 여유 체육복 있는 사람은 자기 체육복은 무조건 갖고 있으므로 다시 true로 입력한다.
        for (int no : reserve) {
            cloth[no] = true;
            getReserve[no] = true;
        }

        // 여유 체육복 가진 사람이 잃어버린 경우, 빌려줄 수 없으므로 false 체크
        for (int no : lost) {
            getReserve[no] = false;
        }

        //1번 부터 n번까지 체크해본다.
        for (int i = 1; i <= n; i++) {
            //체육복을 갖고 있는 경우 answer 값을 증가시킴
            if (cloth[i]) {
                answer++;
            }
            //체육복을 갖고 있지 않는 경우
            else{
                // 앞사람 여유 체육복이 있나 먼저 확인하고 있으면, answer값을 증가시킨다.
                if (getReserve[i - 1]) {
                    answer++;
                // 앞사람 여유 체육복이 없을 경우 뒷사람을 확인한다.
                } else if (getReserve[i + 1]) {
                    answer++;
                    //뒷사람 체육복을 빌린 경우, false 체크를 해주어야한다.
                    getReserve[i + 1] = false;
                }
            }

        }
        return answer;
    }
}