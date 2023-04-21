package LV3.베스트앨범;

// 장르별 2곡씩(1곡인 경우 1곡만)
// 장르별 많은 순, 노래별 많은 순, 고유번호가 낮은순
import java.util.*;
class Solution {
    HashMap<String,Integer> gen;
    HashMap<String,List<int[]>> info;
    List<String> li;
    public int[] solution(String[] genres, int[] plays) {
        countByGenre(genres,plays);
        setMusicInfo(genres,plays);
        ordering();

        List<Integer> ans = new ArrayList<>();

        for(String genre : li){
            List<int[]> musics = info.get(genre);
            for(int i=0;i<musics.size();i++){
                if(i==2){
                    break;
                }
                ans.add(musics.get(i)[0]);
            }
        }

        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    void ordering(){
        Collections.sort(li,new Comparator<String>(){
            @Override
            public int compare(String str1,String str2){
                return gen.get(str2)-gen.get(str1);
            }
        });

        for(List<int[]> list : info.values()){
            Collections.sort(list,(a,b)->b[1]-a[1]);
        }
    }

    void setMusicInfo(String[] genres,int[] plays){
        for(int i=0;i<genres.length;i++){
            info.get(genres[i]).add(new int[]{i,plays[i]});
        }

    }

    void countByGenre(String[] genres,int[] plays){
        gen = new HashMap<>();
        info = new HashMap<>();
        li = new ArrayList<>();
        for(int i=0;i<genres.length;i++){
            gen.put(genres[i],gen.getOrDefault(genres[i],0)+plays[i]);
            info.put(genres[i],new ArrayList<>());
        }
        for(String genre : gen.keySet()){
            li.add(genre);
        }
    }
}