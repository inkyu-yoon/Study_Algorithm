package LV2.주차요금계산;
// 입차 이후 출차 내역이 없다면 23:59 에 출차된것으로 간주
// 누적 주차 시간이 기본 시간 이하면 기본요금
// 단위시간으로 나누어떨어지지 않으면 올림
import java.util.*;
class Solution {
    HashMap<String,String> map;
    HashMap<String,Integer> times;

    public int[] solution(int[] fees, String[] records) {
        map = new HashMap<>();
        times = new HashMap<>();

        for(String record : records){
            String[] info = record.split(" ");
            if(info[2].equals("IN")){
                map.put(info[1],info[0]);
            }else{
                int t = getTimeDiff(map.get(info[1]),info[0]);
                times.put(info[1],times.getOrDefault(info[1],0)+t);
                map.remove(info[1]);
            }
        }

        for(Map.Entry<String,String> entry: map.entrySet()){
            int t = getTimeDiff(entry.getValue(),"23:59");
            times.put(entry.getKey(),times.getOrDefault(entry.getKey(),0)+t);
        }

        int[] ans = new int[times.size()];

        List<int[]> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: times.entrySet()){
            list.add(new int[]{Integer.valueOf(entry.getKey()),calculate(fees,entry.getValue())});
        }

        Collections.sort(list,(a,b)->a[0]-b[0]);

        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i)[1];
        }

        return ans;
    }

    int calculate(int[] fees,int time){
        int result = fees[1];
        time-=fees[0];
        if(time<=0){
            return result;
        }
        result += (int)Math.ceil((double)time/fees[2])*fees[3];
        return result;
    }

    int getTimeDiff(String time1,String time2){
        return convert(time2)-convert(time1);
    }

    int convert(String time){
        String[] info = time.split(":");
        return Integer.parseInt(info[0])*60+Integer.parseInt(info[1]);
    }
}