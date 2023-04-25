package LV2.방금그곡;

//C# D# F# G# A#
import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        m=convert(m);
        List<int[]> ans = new ArrayList<>();

        for(int i=0;i<musicinfos.length;i++){
            String music = musicinfos[i];
            String target = getFullMusic(music);
            if(target.indexOf(m)>=0){
                ans.add(new int[]{target.length(),i});
            }
        }

        Collections.sort(ans,(a,b)->{
            int result = b[0]-a[0];
            if(result ==0){
                return a[1]-b[1];
            }else{
                return result;
            }
        });

        if(ans.isEmpty()){
            return "(None)";
        }else{
            return getMusicName(musicinfos[ans.get(0)[1]]);
        }
    }

    String getMusicName(String info){
        return info.split(",")[2];

    }

    String getFullMusic(String info){
        String[] arr = info.split(",");
        int time = getTimeDiff(arr[0],arr[1]);
        String music = convert(arr[3]);
        int n = time/music.length();
        if(n<1){
            return music.substring(0,time%music.length()+1);
        }else{
            return music.repeat(n+1).substring(0,time);
        }

    }
    int getTimeDiff(String time1,String time2){
        int[] info1 = Arrays.stream(time1.split(":")).mapToInt(Integer::valueOf).toArray();
        int[] info2 = Arrays.stream(time2.split(":")).mapToInt(Integer::valueOf).toArray();
        return 60*(info2[0]-info1[0])+(info2[1]-info1[1]);
    }

    String convert(String music){
        return music.replaceAll("A#","H")
                .replaceAll("C#","I")
                .replaceAll("D#","J")
                .replaceAll("F#","K")
                .replaceAll("G#","L");
    }
}