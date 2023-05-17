package LV2.호텔대실;

// 퇴실 시간을 기준으로 10분간 청소
class Solution {
    public int solution(String[][] book_time) {
        int answer = -1;

        for(int i=0;i<1440;i++){
            int count = 0;
            for(String[] time : book_time){
                if(check(i,time)){
                    count++;
                }
            }
            answer = Math.max(count,answer);
        }

        return answer;
    }
    boolean check(int time, String[] info){
        int[] target = convert(info);

        return (target[0]<=time && time<target[1]+10);
    }

    int[] convert(String [] info){
        int[] result = new int[2];
        String[] time = info[0].split(":");
        result[0]=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);

        time = info[1].split(":");
        result[1]=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
        return result;
    }
}
